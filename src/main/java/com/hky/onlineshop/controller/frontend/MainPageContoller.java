package java.com.hky.onlineshop.controller.frontend;

import java.com.hky.onlineshop.entity.HeadLine;
import java.com.hky.onlineshop.entity.ShopCategory;
import java.com.hky.onlineshop.service.HeadLineService;
import java.com.hky.onlineshop.service.ShopCategoryService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/frontend")
public class MainPageContoller {
	@Autowired
	private ShopCategoryService shopCategoryService;
	
	/**
	 * 初始化前端展示系统的主页信息，包括获取一级店铺类别列表以及头条列表
	 */
	@Autowired
	private HeadLineService headLineService;
	
	@RequestMapping(value="/listmainpageinfo", method=RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> listMainPageInfo(){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<ShopCategory> shopCategoryList = new ArrayList<ShopCategory>();
		try{
			//获取parentId为空的shopCategory
			shopCategoryList = shopCategoryService.getShopCategoryList(null);
			modelMap.put("shopCategoryList", shopCategoryList);
		}catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
			return modelMap;
		}
		List<HeadLine> headLineList = new ArrayList<>();
		try{
			//获取状态可用的（status=1）的头条列表
			HeadLine headLineCondition = new HeadLine();
			headLineCondition.setEnableStatus(1);
			headLineList = headLineService.getHeadLineList(headLineCondition);
			modelMap.put("headLineList", headLineList);
		}catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
			return modelMap;
		}
		modelMap.put("success", true);
		return modelMap;
	}
}
