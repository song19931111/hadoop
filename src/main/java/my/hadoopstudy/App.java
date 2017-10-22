package my.hadoopstudy;

import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Before;

/**
 * Hello world!
 *
 */
public class App 
{
	
	FileSystem fs  = null;
	@Before
	public void  init() throws Exception{
		Configuration conf  = new Configuration();
		conf.set("fs.defaultFS","hdfs://123.207.1.244:9000");
		conf.set("dfs.replication","3");
		fs = FileSystem.get(conf);
		fs = FileSystem.get(new URI("hdfs://123.207.1.244:9000"),conf,"hadoop");
		
	}
	@org.junit.Test
	public void testUpload() throws IllegalArgumentException, IOException{
		fs.copyFromLocalFile(new Path("C://abcfg.json"),new Path ("/test/abcfg.json"));
		
	}
	
	
    @org.junit.Test
    public void Test(){
    	
    }
}
