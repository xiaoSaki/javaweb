package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import po.Procerecord;
import po.ProcerecordExample;

public interface ProcerecordMapper {
    int countByExample(ProcerecordExample example);

    int deleteByExample(ProcerecordExample example);

    int deleteByPrimaryKey(String prid);

    int insert(Procerecord record);

    int insertSelective(Procerecord record);

    List<Procerecord> selectByExample(ProcerecordExample example);

    Procerecord selectByPrimaryKey(String prid);

    int updateByExampleSelective(@Param("record") Procerecord record, @Param("example") ProcerecordExample example);

    int updateByExample(@Param("record") Procerecord record, @Param("example") ProcerecordExample example);

    int updateByPrimaryKeySelective(Procerecord record);

    int updateByPrimaryKey(Procerecord record);
}