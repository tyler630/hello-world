package cn.dbw.luckwheel.service;

import cn.dbw.luckwheel.mapper.LuckUserProductMapper;
import cn.dbw.luckwheel.po.LuckUserProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LuckUserProductService extends BaseService<LuckUserProduct> {
    @Autowired
    private LuckUserProductMapper luckUserProductMapper;

    public int truncateTable(){
        return   luckUserProductMapper.truncateTable();
    }
}
