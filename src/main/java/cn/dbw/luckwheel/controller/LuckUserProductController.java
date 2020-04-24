package cn.dbw.luckwheel.controller;

import cn.dbw.luckwheel.po.LuckUserProduct;
import cn.dbw.luckwheel.service.BaseService;
import cn.dbw.luckwheel.service.LuckUserProductService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("lup")
public class LuckUserProductController extends BaseController<LuckUserProduct> {

    @Autowired
    private LuckUserProductService luckUserProductService;

    @Override
    public BaseService<LuckUserProduct> getBaseService() {
        return luckUserProductService;
    }

    @RequestMapping("lkp")
    public JSONObject getLuckPersonByUid(String uid){
        LuckUserProduct luckUserProduct = new LuckUserProduct();
        luckUserProduct.setUid(uid);
       return success(luckUserProductService.queryList(luckUserProduct),"");
    }

    @RequestMapping("lkall")
    public JSONObject getAllLuckPerson(Integer page, Integer limit){
        return success(luckUserProductService.queryListByPageAadFiled(page, limit, null, "id"),"");

    }

    @RequestMapping("clear")
    public JSONObject clearData() {
        return success(luckUserProductService.truncateTable(), "");
    }
}
