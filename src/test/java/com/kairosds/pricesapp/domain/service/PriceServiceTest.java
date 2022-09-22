package com.kairosds.pricesapp.domain.service;

import com.kairosds.pricesapp.application.ports.output.PriceOutputPort;
import com.kairosds.pricesapp.domain.exception.BrandNotFoundException;
import com.kairosds.pricesapp.domain.exception.PriceNotFoundException;
import com.kairosds.pricesapp.domain.model.Price;
import com.kairosds.pricesapp.mock.MockData;
import com.kairosds.pricesapp.utils.TestUtils;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class PriceServiceTest {

    private final PriceOutputPort priceOutputPort = mock(PriceOutputPort.class);
    private final BrandService brandService = mock(BrandService.class);

    private final PriceService priceService = new PriceService(priceOutputPort, brandService);

    @Test
    void shouldReturnPriceWithPriceList1() {
        doReturn(true).when(brandService).existsById(eq(1L));
        doReturn(MockData.getPrices()).when(priceOutputPort).getPrices();

        LocalDateTime date = TestUtils.createDateTime("14-06-2020 10:00:00");

        Price price = priceService.getPriceForDate(date, 35455L, 1L);

        assertEquals(1L, price.getPriceList());
        assertEquals("35.5", price.getPrice().toString());
    }

    @Test
    void shouldReturnPriceWithPriceList2() {
        doReturn(true).when(brandService).existsById(eq(1L));
        doReturn(MockData.getPrices()).when(priceOutputPort).getPrices();

        LocalDateTime date = TestUtils.createDateTime("14-06-2020 16:00:00");

        Price price = priceService.getPriceForDate(date, 35455L, 1L);

        assertEquals(2L, price.getPriceList());
        assertEquals("25.45", price.getPrice().toString());
    }

    @Test
    void shouldReturnPriceWithPriceList3() {
        doReturn(true).when(brandService).existsById(eq(1L));
        doReturn(MockData.getPrices()).when(priceOutputPort).getPrices();

        LocalDateTime date = TestUtils.createDateTime("15-06-2020 10:00:00");

        Price price = priceService.getPriceForDate(date, 35455L, 1L);

        assertEquals(3L, price.getPriceList());
        assertEquals("30.5", price.getPrice().toString());
    }

    @Test
    void shouldReturnPriceWithPriceList4() {
        doReturn(true).when(brandService).existsById(eq(1L));
        doReturn(MockData.getPrices()).when(priceOutputPort).getPrices();

        LocalDateTime date = TestUtils.createDateTime("16-06-2020 10:00:00");

        Price price = priceService.getPriceForDate(date, 35455L, 1L);

        assertEquals(4L, price.getPriceList());
        assertEquals("38.95", price.getPrice().toString());
    }

    @Test
    void shouldThrowBrandNotFoundException() {
        doReturn(false).when(brandService).existsById(eq(2L));

        BrandNotFoundException brandNotFoundException = assertThrows(BrandNotFoundException.class,
                () -> priceService.getPriceForDate(LocalDateTime.now(), 35455L, 2L)
        );

        assertEquals("Brand with id 2 not found", brandNotFoundException.getMessage());
    }

    @Test
    void shouldThrowPriceNotFoundException() {
        doReturn(true).when(brandService).existsById(eq(1L));
        doReturn(List.of()).when(priceOutputPort).getPrices();

        PriceNotFoundException priceNotFoundException = assertThrows(PriceNotFoundException.class,
                () -> priceService.getPriceForDate(LocalDateTime.now(), 35455L, 1L)
        );

        assertEquals("Price for product with id 35455 not found", priceNotFoundException.getMessage());
    }

}