package org.example;

import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    private static Schema clientIdentifierSchema(){
        Schema clientIdentifier = SchemaBuilder.record("ClientIdentifier")
                .namespace("io.stanford.tim.avro-example")
                .fields()
                .requiredString("hostName")
                .requiredString("ipAddress")
                .endRecord();

        Schema avroHttpRequest = SchemaBuilder.record("AvroHttpRequest")
                .namespace("io.stanford.tim.avro-example")
                .fields().requiredLong("requestTime")
                .name("clientIdentifier")
                .type(clientIdentifier)
                .noDefault()
                .name("employeeNames")
                .type()
                .array()
                .items()
                .stringType()
                .arrayDefault(null)
                .name("active")
                .type()
                .enumeration("Active")
                .symbols("YES","NO")
                .noDefault()
                .endRecord();

        return avroHttpRequest;
    }

    private void generateSchema() throws IOException {
        Schema schema = clientIdentifierSchema();
        var schemaString = schema.toString();
        Files.writeString(Paths.get("/home/tim/schema.avsc"), schemaString);
    }

    public static void main(String[] args) {


    }
}