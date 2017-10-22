package my.hadoopstudy;

import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsPermission;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
   
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
	@Test
	public void testUpload() throws IllegalArgumentException, IOException{
		fs.copyFromLocalFile(new Path("C://adcfg.json"),new Path ("/test/abcfg.json"));
		fs.close();
	}
	
	
    @Test
    public void testDownload() throws IllegalArgumentException, IOException{
    	fs.copyToLocalFile(new Path("/test/output/part-r-00000"),new Path("C://test"));
    	fs.close();
    }
    
    @Test
    public void TestMkdir() throws IllegalArgumentException, IOException{
    	boolean mkdirs = fs.mkdirs(new Path("/testDir"),FsPermission.getDefault());
    	System.out.println(mkdirs);
    }
}
