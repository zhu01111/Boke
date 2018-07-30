package com.zwc.Boke.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.fishlord.common.result.ErrorCode;
import me.fishlord.common.result.ResultEntity;

import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import org.python.util.jython;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonView;
import com.zwc.Boke.pojo.User;
import com.zwc.Boke.pojo.User.ListView;
import com.zwc.Boke.service.UserService;
import com.zwc.Boke.util.*;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//获取服务器路径
	@Value("${file.path}")
	private String path;
	
	@Value("${python.path}")
	private String python;
	
	@Value("${domain}")
	private String domain;
	
	static PythonInterpreter interpreter = new PythonInterpreter();
	@RequestMapping("/getInfo")
	@ResponseBody
	public ResultEntity getInfo(HttpServletResponse response,Integer a,Integer b,String location,Model model) throws Exception{
		response.setHeader("Access-Control-Allow-Origin","*");
		//EmailSendUtil.getCode(new String[]{"wei.0111@qq.com","zhuwc@ittime.xin"});
		ResultEntity resultEntity = new ResultEntity();
		DemoJava demo = new DemoJava();
		resultEntity.setCode(0);
		resultEntity.setData(userService.list());
		resultEntity.setMsg(demo.generateGetDiaryWeatherURL(location));
		//python
		/*PythonInterpreter interpreter = new PythonInterpreter();
		interpreter.execfile(python);
		PyFunction function = interpreter.get("add", PyFunction.class);
		PyObject py = function.__call__(new PyInteger(a),new PyInteger(b));*/
		return resultEntity;
	}
	@RequestMapping("/my")
	public String index(Model model,HttpSession session){
		model.addAttribute("name", "朱伟超真帅");
		model.addAttribute("users", userService.list());
		User user = new User();
		user.setId(7);
		user.setPassword("654321");
		System.err.println(userService.update(user));
		return "pages/myy";
	}
	@RequestMapping("/uploadFile")
	@ResponseBody
	public ResultEntity file(@RequestParam("file")MultipartFile file) throws Exception{
		ResultEntity resultEntity = new ResultEntity();
		if (!file.isEmpty()) {
			//判断文件夹是否存在,如果不存在则新建
			File filePath = new File(path);
			if (!filePath.exists()) {
				filePath.mkdir();
			}
			String fileName = file.getOriginalFilename();
			Integer uuid = UUID.randomUUID().toString().hashCode();
			if (uuid<0) {
				uuid = -uuid;
			}
			String name = String.format("%010d", uuid);
			String ext = fileName.substring(fileName.indexOf("."), fileName.length());
			file.transferTo(new File(path+name+ext));
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setData(domain+name+ext);
		}else {
			resultEntity.setCode(ErrorCode.ERROR);
		}
		return resultEntity;
	}
	@RequestMapping("/detail")
	@ResponseBody
	@JsonView({ListView.class})
	public ResultEntity test(Integer id){
		ResultEntity resultEntity = new ResultEntity();
		User user = userService.findById(id);
		if (user!=null) {
			resultEntity.setCode(0);
			resultEntity.setData(user);			
		}else {
			resultEntity.setCode(-1);
			resultEntity.setMsg("用户不存在");
		}
		
		return resultEntity;
	}
	
	/*启动项目默认首页
	@RequestMapping("/")
	public String in(){
		return "pages/myy";
	}*/
}
