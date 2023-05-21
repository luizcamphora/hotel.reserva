package br.com.reservas.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.reservas.model.Categoria;
import br.com.reservas.model.Quarto;
import br.com.reservas.service.CategoriaService;
import br.com.reservas.service.QuartoService;

@Controller
@RequestMapping("/quarto")
public class QuartoController {

	@Autowired
	private QuartoService quartoService;

	@Autowired
	private CategoriaService categoriaService;

	public QuartoController() {
	}

	@RequestMapping(value = "/lista")
	public ModelAndView listar(ModelAndView model) throws IOException {
		List<Quarto> listQuarto = quartoService.pesquisarQuartos();
		model.addObject("listQuarto", listQuarto);
		model.setViewName("quarto-lista");
		return model;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novo(ModelAndView model) {
		List<Categoria> categorias = categoriaService.pesquisarCategorias();

		Quarto quarto = new Quarto();

		model.addObject("quarto", quarto);
		model.addObject("categorias", categorias);

		model.setViewName("quarto-form");
		return model;
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ModelAndView salvar(@ModelAttribute Quarto quarto, @RequestParam("file") MultipartFile file,
			HttpSession session) {
		String nomeArquivo = "";

		if (!file.isEmpty()) {

			String path = session.getServletContext().getRealPath("/resources/");

			nomeArquivo = file.getOriginalFilename();

			try {
				byte[] bytes = file.getBytes();

				File dir = new File(path + File.separator + "imagens" + File.separator + "quartos");
				if (!dir.exists())
					dir.mkdirs();

				File serverFile = new File(dir.getAbsolutePath() + File.separator + nomeArquivo);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

			} catch (Exception e) {
				System.out.println("You failed to upload " + nomeArquivo + " => " + e.getMessage());
			}
			
			quarto.setPathImagem(nomeArquivo);
			
		} else {
			if (quarto.getPathImagem().isEmpty())
				quarto.setPathImagem(null);
			System.out.println("You failed to upload " + nomeArquivo + " because the file was empty.");
		}

		quartoService.salvar(quarto);
		List<Quarto> listQuarto = quartoService.pesquisarQuartos();

		ModelAndView model = new ModelAndView();
		model.addObject("listQuarto", listQuarto);
		model.addObject("sucesso", Boolean.TRUE);
		model.setViewName("quarto-lista");
		return model;
	}

	@RequestMapping(value = "/deletar", method = RequestMethod.GET)
	public ModelAndView deletar(HttpServletRequest request) {

		Long id = Long.parseLong(request.getParameter("id"));
		quartoService.deletar(id);

		List<Quarto> listQuarto = quartoService.pesquisarQuartos();

		ModelAndView model = new ModelAndView();
		model.addObject("listQuarto", listQuarto);
		model.addObject("sucesso", Boolean.TRUE);
		model.setViewName("quarto-lista");
		return model;
	}

	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public ModelAndView editar(HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter("id"));
		Quarto quarto = quartoService.pesquisarQuartoPorId(id);

		List<Categoria> categorias = categoriaService.pesquisarCategorias();

		ModelAndView model = new ModelAndView("quarto-form");
		model.addObject("quarto", quarto);
		model.addObject("categorias", categorias);

		return model;
	}

	@RequestMapping(value = "/exportar")
	public void exportar(HttpServletResponse response) {

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheetEditoras = workbook.createSheet("Quartos");

		List<Quarto> lista = quartoService.pesquisarQuartos();

		int rownum = 0;

		Row cabecalho = sheetEditoras.createRow(rownum++);

		Cell cellIdCab = cabecalho.createCell(0);
		cellIdCab.setCellValue("ID");

		Cell cellNomeCab = cabecalho.createCell(1);
		cellNomeCab.setCellValue("NOME");

		for (Quarto quarto : lista) {
			Row row = sheetEditoras.createRow(rownum++);
			int cellnum = 0;

			Cell cellId = row.createCell(cellnum++);
			cellId.setCellValue(quarto.getId());

			Cell cellNome = row.createCell(cellnum++);
			cellNome.setCellValue(quarto.getNome());
		}

		try {

			response.setHeader("Content-Disposition", "attachment;filename=\"quartos.xlsx\"");

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
	
	@RequestMapping(value = "/listar-quartos-reservas")
	public ModelAndView listarQuartosReservas(ModelAndView model) throws IOException {
		List<Quarto> listQuarto = quartoService.pesquisarQuartos();
		model.addObject("listQuarto", listQuarto);
		model.setViewName("quarto-lista-reserva");
		return model;
	}
}
