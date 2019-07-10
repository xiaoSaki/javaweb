package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import po.Bom;
import po.BomExample;

public interface BomMapper {
    int countByExample(BomExample example);

    int deleteByExample(BomExample example);

    int insert(Bom record);

    int insertSelective(Bom record);

    List<Bom> selectByExample(BomExample example);

    int updateByExampleSelective(@Param("record") Bom record, @Param("example") BomExample example);

    int updateByExample(@Param("record") Bom record, @Param("example") BomExample example);
}