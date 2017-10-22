package my.hadoopstudy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
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
		fs.delete(new Path("mkdir"),true); //ÊÇ·ñµÝ¹éÉ¾³ý
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
    @Test
    public void TestDelete() throws IllegalArgumentException, IOException{
    	boolean mkdirs = fs.mkdirs(new Path("/testDir"),FsPermission.getDefault());
    	System.out.println(mkdirs);
    }
    @Test
    public void TestList() throws FileNotFoundException, IllegalArgumentException, IOException{
    	//true ÊÇ·ñµÝ¹é
    	RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"),false); 
    	while(listFiles.hasNext()){
    		LocatedFileStatus fileStatus = listFiles.next();
//    		System.out.println(fileStatus.getBlockSize());
//    		System.out.println(fileStatus.getOwner());
    		System.out.println("NAME1:"+fileStatus.getPath());
//    		System.out.println("NAME2:"+fileStatus.getClass().getName());
//    		System.out.println(fileStatus.getReplication());
    	}
    
    }
    @Test
    public void TestListStatus() throws FileNotFoundException, IllegalArgumentException, IOException{
    	FileStatus[] listStatus = fs.listStatus(new Path("/"));
    	for(FileStatus status:listStatus){
    		System.out.println(status.getPath().getName());
    	}
    
    }
}
