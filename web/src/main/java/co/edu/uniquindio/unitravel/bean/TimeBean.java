package co.edu.uniquindio.unitravel.bean;

import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@ViewScoped
@Component
public class TimeBean implements Serializable {

    @Getter @Setter
    private LocalDate date;
    @Getter @Setter
    private LocalDate date1;
    @Future
    @Getter @Setter
    private LocalDate date2;
    @Getter @Setter
    private LocalDate date3;
    @Getter @Setter
    private LocalDate date4;
    @Getter @Setter
    private LocalDate date5;
    @Getter @Setter
    private LocalDate date6;
    @Getter @Setter
    private LocalDate date7;
    @Getter @Setter
    private LocalDate date8;
    @Getter @Setter
    private LocalDate date9;
    @Getter @Setter
    private LocalDate dateDe;
    @Getter @Setter
    private LocalDate date10;
    @Getter @Setter
    private LocalDate date11;
    @Getter @Setter
    private LocalDate date12;
    @Getter @Setter
    private LocalDate date13;
    @Getter @Setter
    private LocalDate date14;
    @Getter @Setter
    private LocalTime time1;
    @Getter @Setter
    private LocalTime time2;
    @Getter @Setter
    private LocalTime time3;
    @Getter @Setter
    private LocalTime time4;
    @Getter @Setter
    private LocalTime time5;
    @Getter @Setter
    private LocalTime time6;
    @Getter @Setter
    private LocalTime time7;
    @Getter @Setter
    private LocalTime time8;
    @Getter @Setter
    private LocalTime time9;
    @Getter @Setter
    private LocalDateTime dateTime1;
    @Future
    @Getter @Setter
    private LocalDateTime dateTime2;
    @Getter @Setter
    private LocalDateTime dateTime3;
    @Getter @Setter
    private LocalDateTime dateTime4;
    @Getter @Setter
    private LocalDateTime dateTime5;
    @Getter @Setter
    private LocalDateTime dateTime6;
    @Getter @Setter
    private LocalDateTime dateTime7;
    @Getter @Setter
    private LocalDateTime dateTimeDe;
    @Getter @Setter
    private List<LocalDate> multi;
    @Getter @Setter
    private List<LocalDate> range;
    @Getter @Setter
    private List<LocalDate> invalidDates;
    @Getter @Setter
    private List<Integer> invalidDays;
    @Getter @Setter
    private LocalDate minDate;
    @Getter @Setter
    private LocalDate maxDate;
    @Getter @Setter
    private LocalTime minTime;
    @Getter @Setter
    private LocalTime maxTime;
    @Getter @Setter
    private LocalDateTime minDateTime;
    @Getter @Setter
    private LocalDateTime maxDateTime;
    @Getter @Setter
    private ZonedDateTime zonedDateTime1;
    @Getter @Setter
    private YearMonth yearMonth;

    @PostConstruct
    public void init() {
        invalidDates = new ArrayList<>();
        invalidDates.add(LocalDate.now());
        for (int i = 0; i < 5; i++) {
            invalidDates.add(invalidDates.get(i).plusDays(1));
        }

        invalidDays = new ArrayList<>();
        invalidDays.add(0);
        /* the first day of week is disabled */
        invalidDays.add(3);

        minDate = LocalDate.now().minusYears(1);
        maxDate = LocalDate.now().plusYears(1);

        minTime = LocalTime.of(9, 0);
        maxTime = LocalTime.of(17, 0);

        minDateTime = LocalDateTime.now().minusWeeks(1);
        maxDateTime = LocalDateTime.now().plusWeeks(1);

        dateDe = LocalDate.of(2019, 7, 27);
        dateTimeDe = LocalDateTime.of(2019, 7, 27, 12, 59);
        dateTime4 = LocalDateTime.now();

        time4 = LocalTime.of(10, 30);
    }

    public void onDateSelect(SelectEvent<LocalDate> event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", event.getObject().format(formatter)));
    }

    public void onDateTimeSelect(SelectEvent<LocalDateTime> event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", event.getObject().format(formatter)));
    }

    public void click() {
        PrimeFaces.current().ajax().update("form:display");
        PrimeFaces.current().executeScript("PF('dlg').show()");
    }
}