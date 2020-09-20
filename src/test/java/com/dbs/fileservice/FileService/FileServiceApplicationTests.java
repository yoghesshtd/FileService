package fileservice.FileService;

import com.dbs.fileservice.FileService.bean.FileDetails;
import com.dbs.fileservice.FileService.bean.FileDetailsResponse;
import com.dbs.fileservice.FileService.services.FileApiService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import java.io.File;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SpringBootApplication
@ContextConfiguration(classes = {FileApiService.class})
class FileServiceApplicationTests {

	@Autowired
	FileApiService fileApiService;

	@DisplayName("Test get all files")
	@Test
	void testGet1() {
		FileDetailsResponse response = fileApiService.getAllFiles(".\\src\\test\\demo");
		assertEquals(true, response.isSuccess());
		assertEquals(6, response.getData().size());
	}

	@DisplayName("Test get attributes of file")
	@Test
	void testGetAttribute1() {
		// Get attributes
		FileDetailsResponse response = fileApiService.getAttributes(".\\src\\test\\demo\\demo2\\sample2");
		FileDetails fileDetail = response.getData().get(0);

		assertEquals(true, response.isSuccess());
		assertEquals(1, response.getData().size());

		assertEquals( ".\\src\\test\\demo\\demo2", fileDetail.getPath());
		assertEquals( "sample2", fileDetail.getName());

		assertEquals( true, fileDetail.getAttributes().isRead());
		assertEquals( true, fileDetail.getAttributes().isExecute());
	}

}
