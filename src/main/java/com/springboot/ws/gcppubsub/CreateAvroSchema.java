package com.springboot.ws.gcppubsub;

import com.google.api.gax.rpc.AlreadyExistsException;
import com.google.cloud.pubsub.v1.SchemaServiceClient;
import com.google.pubsub.v1.ProjectName;
import com.google.pubsub.v1.Schema;
import com.google.pubsub.v1.SchemaName;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class CreateAvroSchema {

//    @Value("${pubsub.topic}")
//    private String topic;
//
//    @Value("${spring.cloud.gcp.project-id}")
//    private String projectId;
//
//    String avscFile ="avro.avsc";
//
//    String schemaId = "Employee";
//
//    @PostConstruct
//    public void createAvroSchemaExample()  {
//
//        ProjectName projectName = ProjectName.of(projectId);
//        SchemaName schemaName = SchemaName.of(projectId, schemaId);
//
//        // Read an Avro schema file formatted in JSON as a string.
//        String avscSource = null;
//        try {
//
//            URL resource =  this.getClass().getClassLoader().getResource(avscFile);
//            File file =  new File(resource.getFile());
//            avscSource = new String(Files.readAllBytes(file.toPath()));
//            try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
//
//                Schema schema =
//                        schemaServiceClient.createSchema(
//                                projectName,
//                                Schema.newBuilder()
//                                        .setName(schemaName.toString())
//                                        .setType(Schema.Type.AVRO)
//                                        .setDefinition(avscSource)
//                                        .build(),
//                                schemaId);
//
//                System.out.println("Created a schema using an Avro schema:\n" + schema);
//            } catch (AlreadyExistsException e) {
//                System.out.println(schemaName + "already exists.");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
