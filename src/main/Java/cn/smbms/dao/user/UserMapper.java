package cn.smbms.dao.user;

import cn.smbms.pojo.SmbmsBill;
import cn.smbms.pojo.SmbmsProvider;
import cn.smbms.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.sql.ParameterMetaData;
import java.util.List;
import java.util.Map;

public interface UserMapper {
    public List<User>getUserList(User users);
    public int add(User user);
    public int  update(User user);
    public int delete(@Param("id")Integer delId);

    public List<User>getUserListByRoleId(@Param("userRole")Integer roleId);

    public List<User>getAddressListByUserId(@Param("id")Integer userId);


    public List<SmbmsBill>cx(SmbmsBill smbmsBill);
    public int zyadd(SmbmsProvider smbmsProvider);
    public  int zyxg(SmbmsProvider smbmsProvider);
    public int zysc(@Param("id") Integer id);
    public List<SmbmsBill> billList(@Param("id") Integer id);
    public List<SmbmsProvider>gys(@Param("proCode") String proCode, @Param("proName")String proNmae);
    public List<SmbmsProvider>jd(Integer[] createdBy);
}