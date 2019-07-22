package cn.printer;

public class TextPaper implements Paper {
    private int charPerLine=16;
    private int linePerPage=5;
    private String content="";
    private  int posX=0;
    private int posY=0;
    private int posP=1;


    public int getCharPerLine() {
        return charPerLine;
    }

    public void setCharPerLine(int charPerLine) {
        this.charPerLine = charPerLine;
    }

    public int getLinePerPage() {
        return linePerPage;
    }

    public void setLinePerPage(int linePerPage) {
        this.linePerPage = linePerPage;
    }

    @Override
    public void putInChar(char c) {
        content+=c;
        ++posX;
        if(posX==charPerLine){
            content+= Paper.newline;
            posX=0;
            ++posY;
        }
        if(posY==linePerPage){
            content+="==第"+posP+"页==";
            posY=0;
            ++posP;
        }
    }

    @Override
    public String getContent() {
        String ret=this.content;
        if(!(posX==0&&posY==0)){
            int count =linePerPage-posY;
            for(int i=0;i<count;++i){
                ret+= Paper.newline;
            }
            ret+="==第"+posP+"页==";
        }


        return ret;
    }

}
