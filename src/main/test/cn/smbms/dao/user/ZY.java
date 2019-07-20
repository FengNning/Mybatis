package cn.smbms.dao.user;

import cn.smbms.pojo.SmbmsBill;
import cn.smbms.pojo.SmbmsProvider;
import cn.smbms.pojo.User;
import cn.smbms.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ZY {
    private Logger logger = Logger.getLogger(ZY.class);
    @Test
    public void cx(){
        SqlSession sqlSession=null;
        List<SmbmsBill> smbmsBillList =new ArrayList<>();
        sqlSession= MyBatisUtil.createSqlSeesion();
        SmbmsBill smbmsBill=new SmbmsBill();
        smbmsBill.setProductName("大");
        smbmsBill.setProviderId(3);
        smbmsBill.setIsPayment(2);
        smbmsBillList=sqlSession.getMapper(UserMapper.class).cx(smbmsBill);
        MyBatisUtil.closeSqlSession(sqlSession);
        for(SmbmsBill bill:smbmsBillList){
            logger.debug(
                    " 订单编码: " + bill.getBillCode() +
                    " 商品名称: " + bill.getProductName() +
                    " 供应商名称: " +bill.getSmbmsProvider().getProName() +
                    " 账单金额: " + bill.getTotalPrice() +
                    " 是否付款: " + bill.getIsPayment()+
                    " 创建时间:" + bill.getCreationDate());
            }
        }
    @Test
    public void zyadd(){
        SqlSession sqlSession=null;
        int count=0;
        sqlSession=MyBatisUtil.createSqlSeesion();
        SmbmsProvider  smbmsProvider=new SmbmsProvider();
        smbmsProvider.setProCode("1");
        smbmsProvider.setProName("小峰");
        smbmsProvider.setProDesc("没有");
        smbmsProvider.setProContact("小峰");
        smbmsProvider.setProPhone("110");
        count=sqlSession.getMapper(UserMapper.class).zyadd(smbmsProvider);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        logger.debug("结果"+count);
    }


    @Test
    public void xg(){
        SqlSession sqlSession=null;
        int count =0;
        Date date=null;
        sqlSession=MyBatisUtil.createSqlSeesion();
        SmbmsProvider smbmsProvider=new SmbmsProvider();
        try {
            date=new SimpleDateFormat("yyyy-MM-dd").parse("2010-09-09");
            smbmsProvider.setModifyDate(date);
            smbmsProvider.setModifyBy(1);
            smbmsProvider.setId(17);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        count=sqlSession.getMapper(UserMapper.class).zyxg(smbmsProvider);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
    }

    @Test
    public void zysc(){
        SqlSession sqlSession=null;
        int count=0;
        sqlSession=MyBatisUtil.createSqlSeesion();
        count=sqlSession.getMapper(UserMapper.class).zysc(16);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);


    }
    @Test
    public void billList(){
        SqlSession sqlSession=null;
        List<SmbmsBill> smbmsBillList=new ArrayList<>();
        sqlSession=MyBatisUtil.createSqlSeesion();
        smbmsBillList=sqlSession.getMapper(UserMapper.class).billList(2);
        MyBatisUtil.closeSqlSession(sqlSession);
        for(SmbmsBill s:smbmsBillList){
            for(SmbmsProvider p:s.getSmbmsProviderList()){
                logger.debug("id:"+p.getId()+" 供应商编码:"+p.getProCode()+" 供应商名称:"+p.getProName()+
                " 供应商联系人:"+p.getProContact()+" 供应商电话:"+p.getProPhone()+" 订单编码:"+s.getBillCode()+
                " 订单名称:"+s.getProductName()+" 订单金额:"+s.getTotalPrice()+" 是否付款:"+s.getIsPayment());
           }
        }
    }

    @Test
    public void gys(){
        SqlSession sqlSession=null;
        List<SmbmsProvider> smbmsBillList=new ArrayList<>();
        sqlSession=MyBatisUtil.createSqlSeesion();
        smbmsBillList=sqlSession.getMapper(UserMapper.class).gys("1","东");
        MyBatisUtil.closeSqlSession(sqlSession);
        for(SmbmsProvider p:smbmsBillList){
            logger.debug("id:"+p.getId()+ " 供应商编码:"+p.getProCode()+" 供应商名称:"+p.getProName()+" 供应商联系人:"+p.getProContact()+
                    " 练习电话:"+p.getProPhone()+" 传真:"+p.getProFax()+" 创建时间:"+p.getCreationDate());
        }
    }
    @Test
    public void jd(){
        SqlSession sqlSession=null;
        List<SmbmsProvider> smbmsProviderList=new ArrayList<>();
        Integer[] id={1,2};
        sqlSession=MyBatisUtil.createSqlSeesion();
        smbmsProviderList=sqlSession.getMapper(UserMapper.class).jd(id);
        MyBatisUtil.closeSqlSession(sqlSession);
        for(SmbmsProvider s:smbmsProviderList){
            logger.debug("id:"+s.getId()+" 姓名:"+s.getProName());
        }

    }
}

