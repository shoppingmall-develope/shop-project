package com.spring.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.myshop.vo.MyshopCategoryVO;
import com.myshop.vo.MyshopProductVO;
import com.spring.service.PageServiceImpl;
import com.spring.service.ProductServiceImpl;

@Controller
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductServiceImpl productService;

	@Autowired
	private PageServiceImpl pageService;
	/**
	 * product_write.do
	 */
	
	
	  @RequestMapping(value="/admin_product_write.do", method=RequestMethod.GET)
	  public ModelAndView admin_product_write() {
		  ModelAndView mv = new ModelAndView();
		  
		  ArrayList<MyshopCategoryVO> list = (ArrayList<MyshopCategoryVO>)productService.cateList("1");
		  /*System.out.print("size = "+ list.size() );
		  for (MyshopCategoryVO vo : list) {
			  System.out.println("66");
			  System.out.print(vo.getCategory_id() + "\t" + vo.getCategory_nm());
		  }*/
		  mv.addObject("list", list);
		  mv.setViewName("/admin/admin_product_write");
		  return mv;
	  }
	 
	  
	  @ResponseBody
	  @RequestMapping(value = "/cateListAjax.do", method= RequestMethod.GET, produces = "text/plain; charset=UTF-8") 
	  public String cateList(String cateCode) {
		  System.out.println(cateCode);
		  List<MyshopCategoryVO> list = productService.cateListAjax(cateCode);
		  JsonObject jobject = new JsonObject();
		  JsonArray jarray = new JsonArray();
		  Gson gson = new Gson();
		  for (MyshopCategoryVO vo : list) {
			  JsonObject jo = new JsonObject();
			  jo.addProperty("category_id", vo.getCategory_id());
			  jo.addProperty("category_nm", vo.getCategory_nm());
			  
			  jarray.add(jo);
		  }
		  jobject.add("list", jarray);
		  System.out.println(gson.toJson(jobject));
		  return gson.toJson(jobject);
	  }
	  

	/*
	 * @RequestMapping(value = "admin_product_write.do", method = RequestMethod.GET)
	 * public void amdin_product_write(Model model) throws Exception { ObjectMapper
	 * objm = new ObjectMapper(); List list = productService.getCateoryList();
	 * 
	 * String getCategoryList = objm.writeValueAsString(list);
	 * model.addAttribute("getCategoryList", getCategoryList); }
	 */

	// product_write.do 필터를 이용한 카테고리 다만 DB level 추가해야함
	/*
	 * @RequestMapping(value="/admin_proudct_write.do", method=RequestMethod.GET)
	 * public ModelAndView admin_product_write() { List<MyshopCategoryVO>
	 * categoryList = productService.cateList();
	 * 
	 * List<MyshopCategoryVO> mainCategory = cateList.stream().filter(it ->
	 * it.getdept_level() == 1).collect(Collectors.toList()); List<MyshopCategoryVO>
	 * middleCategory = cateList.stream().filter(it -> it.getLevel() ==
	 * 2).collect(Collectors.toList()); List<MyshopCategoryVO> subCategory =
	 * cateList.stream().filter(it -> it.getLevel() ==
	 * 3).collect(Collectors.toList());
	 * 
	 * mv.addObject("mainCategory", mainCategory); mv.addObject("middleCategory",
	 * middleCategory); mv.addObject("subCategory", subCategory); }
	 */

	/**
	 * product_write_check.do 추가 처리
	 */
	@RequestMapping(value = "/product_write_check.do", method = RequestMethod.POST)
	public ModelAndView product_write_check(MyshopProductVO vo, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();

		if (vo.getFile1().getOriginalFilename().equals("")) {
			vo.setPfile("");
			vo.setPsfile("");
		} else {
			UUID uuid = UUID.randomUUID();
			vo.setPfile(vo.getFile1().getOriginalFilename());
			vo.setPsfile(uuid + "_" + vo.getFile1().getOriginalFilename());
		}

		int result = productService.getWriteResult(vo);

		if (result == 1) {
			if (!vo.getFile1().getOriginalFilename().equals("")) {
				String path = request.getSession().getServletContext().getRealPath("/");
				path += "\\resources\\upload\\"; // 이미지 업로드할 폴더 설정

				File file = new File(path + vo.getPsfile());
				vo.getFile1().transferTo(file);
			}

			mv.setViewName("redirect:/admin_product_list.do");
		} else {
			mv.setViewName("error_page");
		}
		return mv;
	}

	/**
	 */

	/**
	 * admin_product_list.do : 관리자 등록상품 조회
	 */
	@RequestMapping(value = "/admin_product_list.do", method = RequestMethod.GET)
	public ModelAndView admin_product_list(String rpage) {
		ModelAndView mv = new ModelAndView();

		Map<String, Integer> param = pageService.getPageResult(rpage, "product", productService);
		ArrayList<MyshopProductVO> list = productService.getList(param.get("startCount"), param.get("endCount"));

		mv.addObject("list", list);
		mv.addObject("dbCount", param.get("dbCount"));
		mv.addObject("pageSize", param.get("pageSize"));
		mv.addObject("rpage", param.get("rpage"));
		mv.setViewName("/admin/admin_product_list");

		return mv;
	}

	/** product_list 상품 목록 조회 **/
	@RequestMapping(value = "/product_list.do", method = RequestMethod.GET)
	public ModelAndView product_list(String rpage) {
		ModelAndView mv = new ModelAndView();

		Map<String, Integer> param = pageService.getPageResult(rpage, "product", productService);
		ArrayList<MyshopProductVO> list = productService.getList(param.get("startCount"), param.get("endCount"));

		mv.addObject("list", list);
		mv.addObject("dbCount", param.get("dbCount"));
		mv.addObject("pageSize", param.get("pageSize"));
		mv.addObject("rpage", param.get("rpage"));
		mv.setViewName("/product/product_list");
		System.out.println(mv);
		return mv;
	}

	// 상품상세 페이지
	@RequestMapping(value = "/product_detail.do", method = RequestMethod.GET)
	public ModelAndView product_detail(int pid) {
		ModelAndView mv = new ModelAndView();

		MyshopProductVO vo = productService.getDetail(pid);

		mv.addObject("vo", vo);
		mv.setViewName("/product/product_detail");

		return mv;
	}

}
