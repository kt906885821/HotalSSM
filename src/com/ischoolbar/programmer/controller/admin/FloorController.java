package com.ischoolbar.programmer.controller.admin;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.github.pagehelper.util.StringUtil;
import com.ischoolbar.programmer.entity.admin.Floor;
import com.ischoolbar.programmer.page.admin.Page;
import com.ischoolbar.programmer.service.admin.FloorService;

/*
 * 楼层管理控制器
 * @author kuangtao
 * @Date 2019-08-25 11:03:11
 * @Description 
 *
 */
@RestController("/admin/floor")
public class FloorController {
	
	@Autowired
	private FloorService floorService;
	
	/*
	 * 楼层管理列表页面
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView listModel(ModelAndView model) {
		model.setViewName("floor/list");
		return model;
	}
	
	/*
	 * 楼层添加操作
	 */
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> add(Floor floor) {
		Map<String,String> map = new HashMap<>();
		if (floor == null&&floor.equals(" ")) {
			map.put("type", "error");
			map.put("msg", "请填写正确的信息");
			return map;
			
		}
		if (StringUtil.isEmpty(floor.getName())) {
			map.put("type", "error");
			map.put("msg", "楼层不能为空");
			return map;
		}
		if (floorService.add(floor) <= 0) {
			map.put("type", "error");
			map.put("msg", "添加失败");
			return map;
		}
		map.put("type", "success");
		map.put("msg", "添加成功");
		return map;
	}
	
	/*
	 * 楼层编辑操作
	 */
	@RequestMapping(value="edit",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> edit(Floor floor) {
		Map<String,String> map = new HashMap<>();
		if (floor == null&&floor.equals(" ")) {
			map.put("type", "error");
			map.put("msg", "请填写正确的信息");
			return map;
			
		}
		if (StringUtil.isEmpty(floor.getName())) {
			map.put("type", "error");
			map.put("msg", "楼层不能为空");
			return map;
		}
		if (floorService.edit(floor) <= 0) {
			map.put("type", "error");
			map.put("msg", "修改失败");
			return map;
		}
		map.put("type", "success");
		map.put("msg", "添加成功");
		return map;
	}
	
	/*
	 * 楼层删除操作
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> delete(Long id) {
		Map<String,String> map = new HashMap<>();
		if (id == null&&id.equals(" ")) {
			map.put("type", "error");
			map.put("msg", "请填写正确的信息");
			return map;
			
		}
		try {
			if (floorService.delete(id) <= 0) {
				map.put("type", "error");
				map.put("msg", "删除失败");
				return map;
			}
		}catch (Exception e) {
			map.put("type", "error");
			map.put("msg", "该楼层存在已入住的房间，不能删除");
			return map;
		}
		map.put("type", "success");
		map.put("msg", "删除成功");
		return map;
	}
	
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> list(@RequestParam(name="name",defaultValue="")String name,Page page){
		Map<String,Object> map = new HashMap<>();
		HashMap<String, Object> queryMap = new HashMap<>();
		queryMap.put("name", name);
		queryMap.put("offset",page.getOffset());
		queryMap.put("rows", page.getRows());
		map.put("rows", floorService.findList(queryMap));
		map.put("total", floorService.getTotal(queryMap));
		return queryMap;
	}

	
	
}
