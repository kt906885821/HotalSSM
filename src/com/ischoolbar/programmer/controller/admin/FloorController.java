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
 * ¥����������
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
	 * ¥������б�ҳ��
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView listModel(ModelAndView model) {
		model.setViewName("floor/list");
		return model;
	}
	
	/*
	 * ¥����Ӳ���
	 */
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> add(Floor floor) {
		Map<String,String> map = new HashMap<>();
		if (floor == null&&floor.equals(" ")) {
			map.put("type", "error");
			map.put("msg", "����д��ȷ����Ϣ");
			return map;
			
		}
		if (StringUtil.isEmpty(floor.getName())) {
			map.put("type", "error");
			map.put("msg", "¥�㲻��Ϊ��");
			return map;
		}
		if (floorService.add(floor) <= 0) {
			map.put("type", "error");
			map.put("msg", "���ʧ��");
			return map;
		}
		map.put("type", "success");
		map.put("msg", "��ӳɹ�");
		return map;
	}
	
	/*
	 * ¥��༭����
	 */
	@RequestMapping(value="edit",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> edit(Floor floor) {
		Map<String,String> map = new HashMap<>();
		if (floor == null&&floor.equals(" ")) {
			map.put("type", "error");
			map.put("msg", "����д��ȷ����Ϣ");
			return map;
			
		}
		if (StringUtil.isEmpty(floor.getName())) {
			map.put("type", "error");
			map.put("msg", "¥�㲻��Ϊ��");
			return map;
		}
		if (floorService.edit(floor) <= 0) {
			map.put("type", "error");
			map.put("msg", "�޸�ʧ��");
			return map;
		}
		map.put("type", "success");
		map.put("msg", "��ӳɹ�");
		return map;
	}
	
	/*
	 * ¥��ɾ������
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> delete(Long id) {
		Map<String,String> map = new HashMap<>();
		if (id == null&&id.equals(" ")) {
			map.put("type", "error");
			map.put("msg", "����д��ȷ����Ϣ");
			return map;
			
		}
		try {
			if (floorService.delete(id) <= 0) {
				map.put("type", "error");
				map.put("msg", "ɾ��ʧ��");
				return map;
			}
		}catch (Exception e) {
			map.put("type", "error");
			map.put("msg", "��¥���������ס�ķ��䣬����ɾ��");
			return map;
		}
		map.put("type", "success");
		map.put("msg", "ɾ���ɹ�");
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
