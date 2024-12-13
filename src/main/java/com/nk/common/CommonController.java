package com.nk.common;
import com.nk.wyh.domain.AirCommonCount;
import com.nk.wyh.service.AirCommonCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.util.List;

@Controller
public class CommonController {
    @RequestMapping("/index")
    public String redirectIndex(){
        return "redirect:asserts/index.html";
    }
    @RequestMapping("/")
    public String redirect(){
        return "redirect:asserts/index.html";
    }
    @ResponseBody
    @RequestMapping("/visit_count.do")
    public String visitCount() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/static/asserts/visit_count");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        Integer visit_count = Integer.valueOf(bufferedReader.readLine()) + 1;
        fileInputStream.close();

        File file = new File("src/main/resources/static/asserts/visit_count");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(visit_count.toString().getBytes());
        fileOutputStream.close();
        return visit_count.toString();
    }
}
