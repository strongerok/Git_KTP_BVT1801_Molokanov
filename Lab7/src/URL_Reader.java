import com.company.SiteScanner;

import java.io.*;
import java.net.*;

public class URL_Reader {
    private final String prot="http://";
    int len=prot.length();
    public boolean check(String URl,int depth){
        if (URl.length()<10) return false ;
        String s="";
        if ((depth > 0) && (depth < 80)) {
            if (URl.substring(0, len).equals(prot)){
                s=URl.substring(len+1);
                if (s.length()>0) return true;
            }
        }
        return false;
    }

    protected void Reading(URL_Depth site, WebScanner web)
    {
        try{
            if (check(site.getURL(), site.getDepth()))
            {URL s=new URL(site.getURL());
                String host=s.getHost();
                String path=s.getPath();
                Socket check=new Socket(host,80);
                OutputStream outStream = check.getOutputStream();
                PrintWriter writer = new PrintWriter(new BufferedOutputStream(outStream));
                writer.print("GET "+path + "HTTP/1.1\n" + "Host:" +host+"\n");
                writer.flush();
                com.company.SiteScanner scun=new SiteScanner();
                scun.Scanning(check.getInputStream());
                for (String siteLine: scun.getLine()) {
                    if (check(siteLine,site.getDepth()-1) && !(web.getScanned().contains(siteLine)) &&
                        !(web.getNotScanned().contains(siteLine))) {
                                URL_Depth site2=new URL_Depth(siteLine,site.getDepth()-1);
                                web.addNotScanned(site2);
                    }
                }
                web.addScanned(site);
                check.close();
            }
            web.remove();
        } catch (IOException ex) {web.remove();}
    }
}