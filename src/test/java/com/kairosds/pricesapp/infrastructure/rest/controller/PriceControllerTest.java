package com.kairosds.pricesapp.infrastructure.rest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kairosds.pricesapp.infrastructure.rest.data.request.PriceRequest;
import com.kairosds.pricesapp.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    private MockHttpServletRequestBuilder createGetRequest(PriceRequest requestBody) throws JsonProcessingException {
        return get("/price")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestBody));
    }

    @Test
    void shouldReturnPriceWithPriceList1ForDay14AndHour10() throws Exception {
        LocalDateTime date = TestUtils.createDateTime("14-06-2020 10:00:00");

        PriceRequest requestBody = PriceRequest.builder()
                .date(date)
                .productId(35455L)
                .brandId(1L)
                .build();

        mockMvc.perform(createGetRequest(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(requestBody.getProductId()))
                .andExpect(jsonPath("$.brandId").value(requestBody.getBrandId()))
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.price").value(35.5))
                .andExpect(jsonPath("$.date").value(formatter.format(date)));
    }

    @Test
    void shouldReturnPriceWithPriceList2ForDay14AndHour16() throws Exception {
        LocalDateTime date = TestUtils.createDateTime("14-06-2020 16:00:00");

        PriceRequest requestBody = PriceRequest.builder()
                .date(date)
                .productId(35455L)
                .brandId(1L)
                .build();

        mockMvc.perform(createGetRequest(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(requestBody.getProductId()))
                .andExpect(jsonPath("$.brandId").value(requestBody.getBrandId()))
                .andExpect(jsonPath("$.priceList").value(2))
                .andExpect(jsonPath("$.price").value(25.45))
                .andExpect(jsonPath("$.date").value(formatter.format(date)));
    }

    @Test
    void shouldReturnPriceWithPriceList1ForDay14AndHour21() throws Exception {
        LocalDateTime date = TestUtils.createDateTime("14-06-2020 21:00:00");

        PriceRequest requestBody = PriceRequest.builder()
                .date(date)
                .productId(35455L)
                .brandId(1L)
                .build();

        mockMvc.perform(createGetRequest(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(requestBody.getProductId()))
                .andExpect(jsonPath("$.brandId").value(requestBody.getBrandId()))
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.price").value(35.5))
                .andExpect(jsonPath("$.date").value(formatter.format(date)));
    }

    @Test
    void shouldReturnPriceWithPriceList3ForDay15AndHour10() throws Exception {
        LocalDateTime date = TestUtils.createDateTime("15-06-2020 10:00:00");

        PriceRequest requestBody = PriceRequest.builder()
                .date(date)
                .productId(35455L)
                .brandId(1L)
                .build();

        mockMvc.perform(createGetRequest(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(requestBody.getProductId()))
                .andExpect(jsonPath("$.brandId").value(requestBody.getBrandId()))
                .andExpect(jsonPath("$.priceList").value(3))
                .andExpect(jsonPath("$.price").value(30.5))
                .andExpect(jsonPath("$.date").value(formatter.format(date)));
    }

    @Test
    void shouldReturnPriceWithPriceList1ForDay15AndHour14() throws Exception {
        LocalDateTime date = TestUtils.createDateTime("15-06-2020 14:00:00");

        PriceRequest requestBody = PriceRequest.builder()
                .date(date)
                .productId(35455L)
                .brandId(1L)
                .build();

        mockMvc.perform(createGetRequest(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(requestBody.getProductId()))
                .andExpect(jsonPath("$.brandId").value(requestBody.getBrandId()))
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.price").value(35.5))
                .andExpect(jsonPath("$.date").value(formatter.format(date)));
    }

    @Test
    void shouldReturnPriceWithPriceList4ForDay16AndHour21() throws Exception {
        LocalDateTime date = TestUtils.createDateTime("16-06-2020 21:00:00");

        PriceRequest requestBody = PriceRequest.builder()
                .date(date)
                .productId(35455L)
                .brandId(1L)
                .build();

        mockMvc.perform(createGetRequest(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(requestBody.getProductId()))
                .andExpect(jsonPath("$.brandId").value(requestBody.getBrandId()))
                .andExpect(jsonPath("$.priceList").value(4))
                .andExpect(jsonPath("$.price").value(38.95))
                .andExpect(jsonPath("$.date").value(formatter.format(date)));
    }

    @Test
    void shouldReturnNotFoundForBrand() throws Exception {
        LocalDateTime date = TestUtils.createDateTime("16-06-2020 21:00:00");

        PriceRequest requestBody = PriceRequest.builder()
                .date(date)
                .productId(35455L)
                .brandId(2L)
                .build();

        String errorMessage = String.format("Brand with id %d not found", requestBody.getBrandId());

        mockMvc.perform(createGetRequest(requestBody))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.errorMessages[0]").value(errorMessage));
    }

    @Test
    void shouldReturnNotFoundForPrice() throws Exception {
        LocalDateTime date = TestUtils.createDateTime("16-06-2020 21:00:00");

        PriceRequest requestBody = PriceRequest.builder()
                .date(date)
                .productId(3545L)
                .brandId(1L)
                .build();

        String errorMessage = String.format("Price for product with id %d not found", requestBody.getProductId());

        mockMvc.perform(createGetRequest(requestBody))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.errorMessages[0]").value(errorMessage));
    }

    @Test
    void shouldReturnBadRequestForBrandId() throws Exception {
        LocalDateTime date = TestUtils.createDateTime("16-06-2020 21:00:00");

        PriceRequest requestBody = PriceRequest.builder()
                .date(date)
                .productId(35455L)
                .brandId(null)
                .build();

        String errorMessage = "brandId is required";

        mockMvc.perform(createGetRequest(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorMessages[0]").value(errorMessage));
    }

    @Test
    void shouldReturnBadRequestForProductId() throws Exception {
        LocalDateTime date = TestUtils.createDateTime("16-06-2020 21:00:00");

        PriceRequest requestBody = PriceRequest.builder()
                .date(date)
                .productId(null)
                .brandId(1L)
                .build();

        String errorMessage = "productId is required";

        mockMvc.perform(createGetRequest(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorMessages[0]").value(errorMessage));
    }
}