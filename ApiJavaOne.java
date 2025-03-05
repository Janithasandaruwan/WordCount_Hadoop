
import java.io.IOException;
 
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
 
public class ApiJavaOne {
 
    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://sandbox-hdp.hortonworks.com:8020/");  
 
        String hdfsPath = "/user/maria_dev/";
        
        FileSystem fs = FileSystem.get(conf);
        Path path = new Path(hdfsPath);
        RemoteIterator<LocatedFileStatus> files = fs.listFiles(path, true); 
        
        while (files.hasNext()) {
            LocatedFileStatus file = files.next();
            System.out.println(file);
        }
        
        fs.close();
    }
}