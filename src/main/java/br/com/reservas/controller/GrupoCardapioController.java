package br.com.reservas.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.reservas.model.GrupoCardapio;
import br.com.reservas.model.ItemCardapio;
import br.com.reservas.service.GrupoCardapioService;
import br.com.reservas.service.ItemCardapioService;

@Controller
@RequestMapping("/grupo-cardapio")
public class GrupoCardapioController {

	@Autowired
	private GrupoCardapioService grupoCardapioService;
	
	@Autowired
	private ItemCardapioService itemCardapioService;
	
	public GrupoCardapioController() {
	}

	@RequestMapping(value = "/lista")
	public ModelAndView listar(ModelAndView model) throws IOException {
		List<GrupoCardapio> listGrupoCardapio = grupoCardapioService.pesquisarGrupoCardapios();
		model.addObject("listGrupoCardapio", listGrupoCardapio);
		model.setViewName("grupo-cardapio-lista");
		return model;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novo(ModelAndView model) {
		
		List<ItemCardapio> itens = itemCardapioService.pesquisarItemCardapios();
		
		GrupoCardapio grupoCardapio = new GrupoCardapio();
		model.addObject("grupoCardapio", grupoCardapio);
		model.addObject("itens", itens);
		model.setViewName("grupo-cardapio-form");
		return model;
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ModelAndView salvar(@ModelAttribute GrupoCardapio grupoCardapio) {

		grupoCardapioService.salvar(grupoCardapio);
		List<GrupoCardapio> listGrupoCardapio = grupoCardapioService.pesquisarGrupoCardapios();

		ModelAndView model = new ModelAndView();
		model.addObject("listGrupoCardapio", listGrupoCardapio);
		model.addObject("sucesso", Boolean.TRUE);
		model.setViewName("grupo-cardapio-lista");
		return model;
	}

	@RequestMapping(value = "/deletar", method = RequestMethod.GET)
	public ModelAndView deletar(HttpServletRequest request) {

		Long id = Long.parseLong(request.getParameter("id"));
		grupoCardapioService.deletar(id);

		List<GrupoCardapio> listGrupoCardapio = grupoCardapioService.pesquisarGrupoCardapios();

		ModelAndView model = new ModelAndView();
		model.addObject("listGrupoCardapio", listGrupoCardapio);
		model.addObject("sucesso", Boolean.TRUE);
		model.setViewName("grupo-cardapio-lista");
		return model;
	}

	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public ModelAndView editar(HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter("id"));
		GrupoCardapio grupoCardapio = grupoCardapioService.pesquisarGrupoCardapioPorId(id);
		
		List<ItemCardapio> itens = itemCardapioService.pesquisarItemCardapios();
		
		ModelAndView model = new ModelAndView("grupo-cardapio-form");
		model.addObject("grupoCardapio", grupoCardapio);
		model.addObject("itens", itens);

		return model;
	}
	
	@RequestMapping(value = "/exportar")
	public void exportar(HttpServletResponse response) {

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheetEditoras = workbook.createSheet("GrupoCardapios");

		List<GrupoCardapio> lista = grupoCardapioService.pesquisarGrupoCardapios();
		
		int rownum = 0;

		Row cabecalho = sheetEditoras.createRow(rownum++);

		Cell cellIdCab = cabecalho.createCell(0);
		cellIdCab.setCellValue("ID");

		Cell cellNomeCab = cabecalho.createCell(1);
		cellNomeCab.setCellValue("NOME");

		for (GrupoCardapio grupoCardapio : lista) {
			Row row = sheetEditoras.createRow(rownum++);
			int cellnum = 0;

			Cell cellId = row.createCell(cellnum++);
			cellId.setCellValue(grupoCardapio.getId());

			Cell cellNome = row.createCell(cellnum++);
			cellNome.setCellValue(grupoCardapio.getNome());
		}

		try {

			response.setHeader("Content-Disposition", "attachment;filename=\"grupoCardapios.xlsx\"");

			response.setHeader("Pragma", "public");
			response.setHeader("Cache-Control", "cache");
			response.setHeader("Cache-Control", "must-revalidate");
			response.setContentType("application/vnd.ms-excel");
			response.setContentLength(workbook.getBytes().length);

			OutputStream out = response.getOutputStream();
			out.write(workbook.getBytes(), 0, workbook.getBytes().length);
			out.flush();
			out.close();

			System.out.println("Arquivo Excel criado com sucesso!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Arquivo não encontrado!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erro na edição do arquivo!");
		}

	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/incluir-item", method = RequestMethod.GET)
	public @ResponseBody String incluirItem(@RequestParam("item") String idItem) throws IOException {
		
		ItemCardapio itemCardapio = itemCardapioService.pesquisarItemCardapioPorId(Long.parseLong(idItem));
		GrupoCardapio grupoCardapio = new GrupoCardapio();
		grupoCardapio.getItens().add(itemCardapio);
		
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("prato", itemCardapio.getPrato());
		jsonObject.put("descricao", itemCardapio.getDescricao());
		jsonObject.put("id", itemCardapio.getId());

		jsonArray.add(jsonObject);
		return jsonArray.toJSONString();
	}
}
