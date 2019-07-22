package cn.KeTang;

public class Greeting {
    private String ren;
    private String neirong;

    public String getRen() {
        return ren;
    }

    public void setRen(String ren) {
        this.ren = ren;
    }

    public String getNeirong() {
        return neirong;
    }

    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }

    public void jg(){
        System.out.println(ren+"说"+neirong);
    }
}
