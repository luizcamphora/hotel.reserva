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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.reservas.model.ItemCardapio;
import br.com.reservas.service.ItemCardapioService;

@Controller
@RequestMapping("/item-cardapio")
public class ItemCardapioController {

	@Autowired
	private ItemCardapioService itemCardapioService;
	
	public ItemCardapioController() {
	}

	@RequestMapping(value = "/lista")
	public ModelAndView listar(ModelAndView model) throws IOException {
		List<ItemCardapio> listItemCardapio = itemCardapioService.pesquisarItemCardapios();
		model.addObject("listItemCardapio", listItemCardapio);
		model.setViewName("item-cardapio-lista");
		return model;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novo(ModelAndView model) {
		
		ItemCardapio itemCardapio = new ItemCardapio();
		model.addObject("itemCardapio", itemCardapio);
		model.setViewName("item-cardapio-form");
		return model;
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ModelAndView salvar(@ModelAttribute ItemCardapio itemCardapio) {

		itemCardapioService.salvar(itemCardapio);
		List<ItemCardapio> listItemCardapio = itemCardapioService.pesquisarItemCardapios();

		ModelAndView model = new ModelAndView();
		model.addObject("listItemCardapio", listItemCardapio);
		model.addObject("sucesso", Boolean.TRUE);
		model.setViewName("item-cardapio-lista");
		return model;
	}

	@RequestMapping(value = "/deletar", method = RequestMethod.GET)
	public ModelAndView deletar(HttpServletRequest request) {

		Long id = Long.parseLong(request.getParameter("id"));
		itemCardapioService.deletar(id);

		List<ItemCardapio> listItemCardapio = itemCardapioService.pesquisarItemCardapios();

		ModelAndView model = new ModelAndView();
		model.addObject("listItemCardapio", listItemCardapio);
		model.addObject("sucesso", Boolean.TRUE);
		model.setViewName("item-cardapio-lista");
		return model;
	}

	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public ModelAndView editar(HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter("id"));
		ItemCardapio itemCardapio = itemCardapioService.pesquisarItemCardapioPorId(id);
		ModelAndView model = new ModelAndView("item-cardapio-form");
		model.addObject("itemCardapio", itemCardapio);

		return model;
	}
	
	@RequestMapping(value = "/exportar")
	public void exportar(HttpServletResponse response) {

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheetEditoras = workbook.createSheet("ItemCardapios");

		List<ItemCardapio> lista = itemCardapioService.pesquisarItemCardapios();
		
		int rownum = 0;

		Row cabecalho = sheetEditoras.createRow(rownum++);

		Cell cellIdCab = cabecalho.createCell(0);
		cellIdCab.setCellValue("ID");

		Cell cellNomeCab = cabecalho.createCell(1);
		cellNomeCab.setCellValue("PRATO");

		for (ItemCardapio itemCardapio : lista) {
			Row row = sheetEditoras.createRow(rownum++);
			int cellnum = 0;

			Cell cellId = row.createCell(cellnum++);
			cellId.setCellValue(itemCardapio.getId());

			Cell cellNome = row.createCell(cellnum++);
			cellNome.setCellValue(itemCardapio.getPrato());
		}

		try {

			response.setHeader("Content-Disposition", "attachment;filename=\"itemCardapios.xlsx\"");

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
}
