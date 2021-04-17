package com.digitalinnotavionone.heroesapi.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import io.netty.util.internal.StringUtil;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import static com.digitalinnotavionone.heroesapi.constants.HeroesConstant.DYNAMO_REGION;
import static com.digitalinnotavionone.heroesapi.constants.HeroesConstant.DYNAMO_ENDPOINT;

public class HeroesData {
    public static void main(String[] args) throws Exception{
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(DYNAMO_ENDPOINT, DYNAMO_REGION))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Heroes_Table");
        Item hero = new Item()
                .withPrimaryKey("id", "1")
                .withString("name", "Iron Man")
                .withString("universe", "Marvel")
                .withNumber("films", 3);

        Item hero2 = new Item()
                .withPrimaryKey("id", "2")
                .withString("name", "Captain America")
                .withString("universe", "Marvel")
                .withNumber("films", 3);

        Item hero3 = new Item()
                .withPrimaryKey("id", "3")
                .withString("name", "Thor")
                .withString("universe", "Marvel")
                .withNumber("films", 3);

        PutItemOutcome outcome = table.putItem(hero);
        outcome = table.putItem(hero2);
        outcome = table.putItem(hero3);

    }
}
