package com.discount.tracking.services;

import com.discount.tracking.dtos.PaymentDto;
import com.discount.tracking.dtos.response.PaymentItemDto;
import com.discount.tracking.dtos.response.ResponsePaymentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private WebClient webClient;

    @Override
    public ArrayList<PaymentDto> getPayments() {
        String uri = "payments/search?sort=date_created&criteria=desc";
        ArrayList<PaymentDto> paymentList = new ArrayList<>();

        ResponsePaymentDto response = webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(ResponsePaymentDto.class).block();

        if(response != null) {
            for(PaymentItemDto paymentItem : response.results) {
                paymentList.add(paymentItem.payment);
            }
        }

        return paymentList;
    }


    @Override
    public ArrayList<PaymentDto>  getPaymentsByPeriod(int period) {
        Date date = new Date();
        LocalDate nowDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year = nowDate.getYear();
        ArrayList<PaymentDto> payments = getPayments();
        ArrayList<PaymentDto> paymentsInPerdiod = new ArrayList<>();

        for(PaymentDto payment : payments) {
            LocalDate paymentLocalDate = payment.date_created.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int paymentPeriod = paymentLocalDate.getMonthValue();
            int paymentYearPeriod = paymentLocalDate.getYear();
            if(period == paymentPeriod && year == paymentYearPeriod) paymentsInPerdiod.add(payment);
        }
        return paymentsInPerdiod;
    }


}
