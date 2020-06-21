public class URL_Depth {
    private String URl;
    private int depth;
    public URL_Depth() {
        depth=0;
        URl="";
    }
    public URL_Depth(String URL,int depth) {
        this.depth=depth;
        this.URl=URL;
    }
    public void setDepth(int depth) {
        this.depth = depth;
    }
    public void setURL(String URl){
        this.URl=URl;
    }
    public int getDepth(){
        return depth;
    }
    public String getURL(){
        return URl;
    }

}
