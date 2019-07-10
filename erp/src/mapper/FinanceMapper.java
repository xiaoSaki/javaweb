package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import po.Finance;
import po.FinanceExample;

public interface FinanceMapper {
    int countByExample(FinanceExample example);

    int deleteByExample(FinanceExample example);

    int deleteByPrimaryKey(String fid);

    int insert(Finance record);

    int insertSelective(Finance record);

    List<Finance> selectByExample(FinanceExample example);

    Finance selectByPrimaryKey(String fid);

    int updateByExampleSelective(@Param("record") Finance record, @Param("example") FinanceExample example);

    int updateByExample(@Param("record") Finance record, @Param("example") FinanceExample example);

    int updateByPrimaryKeySelective(Finance record);

    int updateByPrimaryKey(Finance record);
}