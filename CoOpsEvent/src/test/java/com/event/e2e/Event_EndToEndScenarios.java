package com.event.e2e;

import com.event.pages.*;
import com.org.coops.base.BaseTest;
import com.org.coops.utilities.DataProviderUtils;
import org.testng.annotations.Test;

public class Event_EndToEndScenarios extends BaseTest {

    @Test(description = "Validate to Purchase a single event policy as an individual", priority = 1, dataProvider = "eventUI_Web_TestData", dataProviderClass = DataProviderUtils.class)
    public void validate_Event_E2EScenario_SingleEvent_Individual(String eventType, String eventLocation, String eventHostingType, String coverageDays, String startDate, String selectHour, String selectMinute, String selectAmPm, String endDate,  String selectEndHour, String selectEndMinute, String selectEndAmPm, String numberOfAttendees, String alcoholServed, String nameOfEvent, String eventHost, String entityName, String province, String entityEmail,  String entityPhone, String addInfo){
        System.out.println("Validate : To Purchase A Single Event policy as an Individual");

        EventType typeOfEvent = new EventType(page);
        typeOfEvent.isEventTypePageLoaded();
        typeOfEvent.selectEventType(eventType);

        EventHosting eventHosting = new EventHosting(page);
        eventHosting.isEventHostingPageLoaded();
        eventHosting.selectEventHosting(eventHostingType);


        EventLocation eventLoc = new EventLocation(page);
        eventLoc.isEventLocationPageLoaded();
        eventLoc.searchVenueAddress1(eventLocation);

        EventDuration eventDur = new EventDuration(page);
        eventDur.isEventDurationPageLoaded();
        eventDur.selectStartDate(startDate, selectHour, selectMinute, selectAmPm);
        eventDur.selectEndDate(endDate, selectEndHour, selectEndMinute, selectEndAmPm);

        EventDetails eventDet = new EventDetails(page);
        eventDet.isEventDetailsPageLoaded();
        eventDet.enterEventDetails(numberOfAttendees, alcoholServed, nameOfEvent);


        EventCoverage eventCov = new EventCoverage(page);
        eventCov.isEventCoveragePageLoaded();
        //eventCov.enterCoverageDetails(eventHost, entityName, entityEmail, entityPhone, province);
        eventCov.enterCoverageDetails(eventHost, entityName, "monika.srivastava-x+singleeventijmp@unqork.com", entityPhone, province);

        EventQuote eventQuote = new EventQuote(page);
        eventQuote.isEventQuotePageLoaded();
        eventQuote.enterQuoteDetails();

        EventAddedInsurance addedInsurance = new EventAddedInsurance(page);
        addedInsurance.isEventAddedInsurancePageLoaded();
        addedInsurance.enterAddedInsuranceDetails();

        EventReviewAddedInsurance reviewIns = new EventReviewAddedInsurance(page);
        reviewIns.isEventReviewAddedInsurancePageLoaded();
        reviewIns.reviewAddedInsuranceDetails();

        EventPaymentDetails paymentDet = new EventPaymentDetails(page);
        paymentDet.isEventPaymentDetailsPageLoaded();
        paymentDet.enterPaymentDetails();

        EventProtected eventDash = new EventProtected(page);
        eventDash.isEventProtectedPageLoaded();
        eventDash.eventDashboard();

    }

    @Test(description = "Validate to Purchase multiple events policy as an individual", priority = 1, dataProvider = "eventUI_Web_TestData", dataProviderClass = DataProviderUtils.class)
    public void validate_Event_E2EScenario_MultipleEvents_Individual(String eventType, String eventLocation, String eventHostingType, String coverageDays, String startDate, String selectHour, String selectMinute, String selectAmPm, String endDate,  String selectEndHour, String selectEndMinute, String selectEndAmPm, String numberOfAttendees, String alcoholServed, String nameOfEvent, String eventHost, String entityName, String province, String entityEmail,  String entityPhone, String addInfo){
        System.out.println("Validate : To Purchase  Multiple Events policy as an Individual");

        EventType typeOfEvent = new EventType(page);
        typeOfEvent.isEventTypePageLoaded();
        typeOfEvent.selectEventType(eventType);

        EventHosting eventHosting = new EventHosting(page);
        eventHosting.isEventHostingPageLoaded();
        eventHosting.selectEventHosting(eventHostingType);


        EventLocation eventLoc = new EventLocation(page);

        eventLoc.isEventLocationPageLoaded();
        eventLoc.searchVenueAddress3(eventLocation);

        EventDuration eventDur = new EventDuration(page);
        eventDur.isEventDurationPageLoaded();
        eventDur.coverageRequiredDays(eventHostingType,coverageDays);
        eventDur.selectStartDate(startDate, selectHour, selectMinute, selectAmPm);
        eventDur.selectEndDate(endDate, selectEndHour, selectEndMinute, selectEndAmPm);

        EventDetails eventDet = new EventDetails(page);
        eventDet.isEventDetailsPageLoaded();
        eventDet.enterEventDetails(numberOfAttendees, alcoholServed, nameOfEvent);


        EventCoverage eventCov = new EventCoverage(page);
        eventCov.isEventCoveragePageLoaded();
        //eventCov.enterCoverageDetails(eventHost, entityName, entityEmail, entityPhone, province);
        eventCov.enterCoverageDetails(eventHost, entityName, "monika.srivastava-x+multieventsijmp@unqork.com", entityPhone, province);

        EventQuote eventQuote = new EventQuote(page);
        eventQuote.isEventQuotePageLoaded();
        eventQuote.enterQuoteDetails();

        EventAddedInsurance addedInsurance = new EventAddedInsurance(page);
        addedInsurance.isEventAddedInsurancePageLoaded();
        addedInsurance.enterAddedInsuranceDetails();

        EventReviewAddedInsurance reviewIns = new EventReviewAddedInsurance(page);
        reviewIns.isEventReviewAddedInsurancePageLoaded();
        reviewIns.reviewAddedInsuranceDetails();

        EventPaymentDetails paymentDet = new EventPaymentDetails(page);
        paymentDet.isEventPaymentDetailsPageLoaded();
        paymentDet.enterPaymentDetails();

        EventProtected eventDash = new EventProtected(page);
        eventDash.isEventProtectedPageLoaded();
        eventDash.eventDashboard();

    }
    @Test(description = "Validate to Purchase a single event policy as a Business", priority = 1, dataProvider = "eventUI_Web_TestData", dataProviderClass = DataProviderUtils.class)
    public void validate_Event_E2EScenario_SingleEvent_Business(String eventType, String eventLocation, String eventHostingType, String coverageDays, String startDate, String selectHour, String selectMinute, String selectAmPm, String endDate,  String selectEndHour, String selectEndMinute, String selectEndAmPm, String numberOfAttendees, String alcoholServed, String nameOfEvent, String eventHost, String entityName, String province, String entityEmail,  String entityPhone, String addInfo){
        System.out.println("Validate : To Purchase A Single Event policy as a Business");

        EventType typeOfEvent = new EventType(page);
        typeOfEvent.isEventTypePageLoaded();
        typeOfEvent.selectEventType(eventType);

        EventHosting eventHosting = new EventHosting(page);
        eventHosting.isEventHostingPageLoaded();
        eventHosting.selectEventHosting(eventHostingType);


        EventLocation eventLoc = new EventLocation(page);
        eventLoc.isEventLocationPageLoaded();
        eventLoc.searchVenueAddress1(eventLocation);

        EventDuration eventDur = new EventDuration(page);
        eventDur.isEventDurationPageLoaded();
        eventDur.selectStartDate(startDate, selectHour, selectMinute, selectAmPm);
        eventDur.selectEndDate(endDate, selectEndHour, selectEndMinute, selectEndAmPm);

        EventDetails eventDet = new EventDetails(page);
        eventDet.isEventDetailsPageLoaded();
        eventDet.enterEventDetails(numberOfAttendees, alcoholServed, nameOfEvent);


        EventCoverage eventCov = new EventCoverage(page);
        eventCov.isEventCoveragePageLoaded();
        //eventCov.enterCoverageDetails(eventHost, entityName, entityEmail, entityPhone, province);
        eventCov.enterCoverageDetails(eventHost, entityName, "monika.srivastava-x+singleeventbusinessp@unqork.com", entityPhone, province);

        EventQuote eventQuote = new EventQuote(page);
        eventQuote.isEventQuotePageLoaded();
        eventQuote.enterQuoteDetails();

        EventAddedInsurance addedInsurance = new EventAddedInsurance(page);
        addedInsurance.isEventAddedInsurancePageLoaded();
        addedInsurance.enterAddedInsuranceDetails();

        EventReviewAddedInsurance reviewIns = new EventReviewAddedInsurance(page);
        reviewIns.isEventReviewAddedInsurancePageLoaded();
        reviewIns.reviewAddedInsuranceDetails();

        EventPaymentDetails paymentDet = new EventPaymentDetails(page);
        paymentDet.isEventPaymentDetailsPageLoaded();
        paymentDet.enterPaymentDetails();

        EventProtected eventDash = new EventProtected(page);
        eventDash.isEventProtectedPageLoaded();
        eventDash.eventDashboard();

    }

    @Test(description = "Validate to Purchase multiple events policy as a Business", priority = 1, dataProvider = "eventUI_Web_TestData", dataProviderClass = DataProviderUtils.class)
    public void validate_Event_E2EScenario_MultipleEvents_Business(String eventType, String eventLocation, String eventHostingType, String coverageDays, String startDate, String selectHour, String selectMinute, String selectAmPm, String endDate,  String selectEndHour, String selectEndMinute, String selectEndAmPm, String numberOfAttendees, String alcoholServed, String nameOfEvent, String eventHost, String entityName, String province, String entityEmail,  String entityPhone, String addInfo){
        System.out.println("Validate : To Purchase  Multiple Events policy as a Business");

        EventType typeOfEvent = new EventType(page);
        typeOfEvent.isEventTypePageLoaded();
        typeOfEvent.selectEventType(eventType);

        EventHosting eventHosting = new EventHosting(page);
        eventHosting.isEventHostingPageLoaded();
        eventHosting.selectEventHosting(eventHostingType);


        EventLocation eventLoc = new EventLocation(page);

        eventLoc.isEventLocationPageLoaded();
        eventLoc.searchVenueAddress3(eventLocation);

        EventDuration eventDur = new EventDuration(page);
        eventDur.isEventDurationPageLoaded();
        eventDur.coverageRequiredDays(eventHostingType,coverageDays);
        eventDur.selectStartDate(startDate, selectHour, selectMinute, selectAmPm);
        eventDur.selectEndDate(endDate, selectEndHour, selectEndMinute, selectEndAmPm);

        EventDetails eventDet = new EventDetails(page);
        eventDet.isEventDetailsPageLoaded();
        eventDet.enterEventDetails(numberOfAttendees, alcoholServed, nameOfEvent);


        EventCoverage eventCov = new EventCoverage(page);
        eventCov.isEventCoveragePageLoaded();
        //eventCov.enterCoverageDetails(eventHost, entityName, entityEmail, entityPhone, province);
        eventCov.enterCoverageDetails(eventHost, entityName, "monika.srivastava-x+multieventsbusiness@unqork.com", entityPhone, province);

        EventQuote eventQuote = new EventQuote(page);
        eventQuote.isEventQuotePageLoaded();
        eventQuote.enterQuoteDetails();

        EventAddedInsurance addedInsurance = new EventAddedInsurance(page);
        addedInsurance.isEventAddedInsurancePageLoaded();
        addedInsurance.enterAddedInsuranceDetails();

        EventReviewAddedInsurance reviewIns = new EventReviewAddedInsurance(page);
        reviewIns.isEventReviewAddedInsurancePageLoaded();
        reviewIns.reviewAddedInsuranceDetails();

        EventPaymentDetails paymentDet = new EventPaymentDetails(page);
        paymentDet.isEventPaymentDetailsPageLoaded();
        paymentDet.enterPaymentDetails();

        EventProtected eventDash = new EventProtected(page);
        eventDash.isEventProtectedPageLoaded();
        eventDash.eventDashboard();

    }

}


