package com.event.e2e;

import com.event.pages.*;
import com.org.coops.base.BaseTest;
import com.org.coops.utilities.DataProviderUtils;
import org.testng.annotations.Test;

public class Event_EndToEndScenarios extends BaseTest {

    @Test(description = "Validate to Purchase a single event policy as an individual", priority = 1, dataProvider = "eventUI_Web_TestData", dataProviderClass = DataProviderUtils.class)
    public void validate_Event_E2EScenario_SingleEvent_Individual(String eventType, String eventLocation, String eventHostingType, String coverageDays, String startDate, String selectHour, String selectMinute, String selectAmPm, String endDate,  String selectEndHour, String selectEndMinute, String selectEndAmPm, String numberOfAttendees, String alcoholServed, String nameOfEvent, String eventHost, String entityName, String addPolicy,String addCard,String addInsuredsName, String addInsuredsEmail,String province, String entityEmail,  String entityPhone, String addInfo){
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
        eventCov.enterCoverageDetails(eventHost, entityName, "monika.srivastava-x+singleeventaddcard1222@unqork.com", entityPhone, province);

        EventQuote eventQuote = new EventQuote(page);
        eventQuote.isEventQuotePageLoaded();
        eventQuote.enterQuoteDetails(alcoholServed);

        EventAddedInsurance addedInsurance = new EventAddedInsurance(page);
        addedInsurance.isEventAddedInsurancePageLoaded();
        addedInsurance.enterAddedInsuranceDetails();

        EventReviewAddedInsurance reviewIns = new EventReviewAddedInsurance(page);
        reviewIns.isEventReviewAddedInsurancePageLoaded();
        reviewIns.reviewAddedInsuranceDetails();

        EventPaymentDetails paymentDet = new EventPaymentDetails(page);
        paymentDet.isEventPaymentDetailsPageLoaded();
        paymentDet.enterPaymentDetails(addCard);

        EventProtected eventDash = new EventProtected(page);
        eventDash.isEventProtectedPageLoaded();
        eventDash.eventDashboard();

    }

    @Test(description = "Validate to Purchase multiple events policy as an individual", priority = 1, dataProvider = "eventUI_Web_TestData", dataProviderClass = DataProviderUtils.class)
    public void validate_Event_E2EScenario_MultipleEvents_Individual(String eventType, String eventLocation, String eventHostingType, String coverageDays, String startDate, String selectHour, String selectMinute, String selectAmPm, String endDate,  String selectEndHour, String selectEndMinute, String selectEndAmPm, String numberOfAttendees, String alcoholServed, String nameOfEvent, String eventHost, String entityName, String addPolicy,String addCard,String addInsuredsName, String addInsuredsEmail, String province, String entityEmail,  String entityPhone, String addInfo){
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
        eventCov.enterCoverageDetails(eventHost, entityName, "monika.srivastava-x+multievents111boaddcard@unqork.com", entityPhone, province);

        EventQuote eventQuote = new EventQuote(page);
        eventQuote.isEventQuotePageLoaded();
        eventQuote.enterQuoteDetails(alcoholServed);

        EventAddedInsurance addedInsurance = new EventAddedInsurance(page);
        addedInsurance.isEventAddedInsurancePageLoaded();
        addedInsurance.enterAddedInsuranceDetails();

        EventReviewAddedInsurance reviewIns = new EventReviewAddedInsurance(page);
        reviewIns.isEventReviewAddedInsurancePageLoaded();
        reviewIns.reviewAddedInsuranceDetails();

        EventPaymentDetails paymentDet = new EventPaymentDetails(page);
        paymentDet.isEventPaymentDetailsPageLoaded();
        paymentDet.enterPaymentDetails(addCard);

        EventProtected eventDash = new EventProtected(page);
        eventDash.isEventProtectedPageLoaded();
        eventDash.eventDashboard();

    }

    @Test(description = "Validate to Purchase a single event policy as a Business", priority = 1, dataProvider = "eventUI_Web_TestData", dataProviderClass = DataProviderUtils.class)
    public void validate_Event_E2EScenario_SingleEvent_Business(String eventType, String eventLocation, String eventHostingType, String coverageDays, String startDate, String selectHour, String selectMinute, String selectAmPm, String endDate,  String selectEndHour, String selectEndMinute, String selectEndAmPm, String numberOfAttendees, String alcoholServed, String nameOfEvent, String eventHost, String entityName, String addPolicy, String addCard,String province, String entityEmail,  String entityPhone, String addInfo){
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
        eventCov.enterCoverageDetails(eventHost, entityName, "monika.srivastava-x+singleeventbusinessdemo1@unqork.com", entityPhone, province);

        EventQuote eventQuote = new EventQuote(page);
        eventQuote.isEventQuotePageLoaded();
        eventQuote.enterQuoteDetails(alcoholServed);

        EventAddedInsurance addedInsurance = new EventAddedInsurance(page);
        addedInsurance.isEventAddedInsurancePageLoaded();
        addedInsurance.enterAddedInsuranceDetails();

        EventReviewAddedInsurance reviewIns = new EventReviewAddedInsurance(page);
        reviewIns.isEventReviewAddedInsurancePageLoaded();
        reviewIns.reviewAddedInsuranceDetails();

        EventPaymentDetails paymentDet = new EventPaymentDetails(page);
        paymentDet.isEventPaymentDetailsPageLoaded();
        paymentDet.enterPaymentDetails(addCard);

        EventProtected eventDash = new EventProtected(page);
        eventDash.isEventProtectedPageLoaded();
        eventDash.eventDashboard();

    }

    @Test(description = "Validate to Purchase multiple events policy as a Business", priority = 1, dataProvider = "eventUI_Web_TestData", dataProviderClass = DataProviderUtils.class)
    public void validate_Event_E2EScenario_MultipleEvents_Business(String eventType, String eventLocation, String eventHostingType, String coverageDays, String startDate, String selectHour, String selectMinute, String selectAmPm, String endDate,  String selectEndHour, String selectEndMinute, String selectEndAmPm, String numberOfAttendees, String alcoholServed, String nameOfEvent, String eventHost, String entityName, String addPolicy, String addCard,String province, String entityEmail,  String entityPhone, String addInfo){
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
        eventCov.enterCoverageDetails(eventHost, entityName, "monika.srivastava-x+multieventsbusinessdemo1@unqork.com", entityPhone, province);

        EventQuote eventQuote = new EventQuote(page);
        eventQuote.isEventQuotePageLoaded();
        eventQuote.enterQuoteDetails(alcoholServed);

        EventAddedInsurance addedInsurance = new EventAddedInsurance(page);
        addedInsurance.isEventAddedInsurancePageLoaded();
        addedInsurance.enterAddedInsuranceDetails();

        EventReviewAddedInsurance reviewIns = new EventReviewAddedInsurance(page);
        reviewIns.isEventReviewAddedInsurancePageLoaded();
        reviewIns.reviewAddedInsuranceDetails();

        EventPaymentDetails paymentDet = new EventPaymentDetails(page);
        paymentDet.isEventPaymentDetailsPageLoaded();
        paymentDet.enterPaymentDetails(addCard);

        EventProtected eventDash = new EventProtected(page);
        eventDash.isEventProtectedPageLoaded();
        eventDash.eventDashboard();

    }

    @Test(description = "Validate to Purchase a single event policy as an individual with CoHost", priority = 1, dataProvider = "eventUI_Web_TestData", dataProviderClass = DataProviderUtils.class)
    public void validate_Event_E2EScenario_SingleEvent_IndividualCoHost(String eventType, String eventLocation, String eventHostingType, String coverageDays, String startDate, String selectHour, String selectMinute, String selectAmPm, String endDate,  String selectEndHour, String selectEndMinute, String selectEndAmPm, String numberOfAttendees, String alcoholServed, String nameOfEvent, String eventHost, String entityName, String addPolicy, String addCard,String coHostName, String coHostEmail, String province, String entityEmail,  String entityPhone, String addInfo){
        System.out.println("Validate : To Purchase A Single Event policy as an Individual with CoHost");

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
        eventCov.enterCoverageDetails(eventHost, entityName, "monika.srivastava-x+singleeventcohosttest2t1132@unqork.com", entityPhone, province);

        EventQuote eventQuote = new EventQuote(page);
        eventQuote.isEventQuotePageLoaded();
        eventQuote.enterQuoteDetails(alcoholServed);

        EventAddedInsurance addedInsurance = new EventAddedInsurance(page);
        EventCoHost coHost = new EventCoHost(page);


        addedInsurance.isEventAddedInsurancePageLoaded();
        addedInsurance.enterAddedInsuranceDetails(addPolicy).isEventCoHostPageLoaded();


        coHost.enterCoHostDetails(coHostName, coHostEmail);

        addedInsurance.enterAddedInsuranceDetails();


        EventReviewAddedInsurance reviewIns = new EventReviewAddedInsurance(page);
        reviewIns.isEventReviewAddedInsurancePageLoaded();
        reviewIns.reviewAddedInsuranceDetails();

        EventPaymentDetails paymentDet = new EventPaymentDetails(page);
        paymentDet.isEventPaymentDetailsPageLoaded();
        paymentDet.enterPaymentDetails(addCard);

        EventProtected eventDash = new EventProtected(page);
        eventDash.isEventProtectedPageLoaded();
        eventDash.eventDashboard();

    }

    @Test(description = "Validate to Purchase multiple events policy as an individual with Additional Insureds", priority = 1, dataProvider = "eventUI_Web_TestData", dataProviderClass = DataProviderUtils.class)
    public void validate_Event_E2EScenario_MultipleEvents_IndividualInsureds(String eventType, String eventLocation, String eventHostingType, String coverageDays, String startDate, String selectHour, String selectMinute, String selectAmPm, String endDate,  String selectEndHour, String selectEndMinute, String selectEndAmPm, String numberOfAttendees, String alcoholServed, String nameOfEvent, String eventHost, String entityName, String addPolicy,String addCard,String addInsuredsName, String addInsuredsEmail, String province, String entityEmail,  String entityPhone, String addInfo){
        System.out.println("Validate : To Purchase  Multiple Events policy as an Individual with Additional Insureds");

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
        eventCov.enterCoverageDetails(eventHost, entityName, "monika.srivastava-x+multieventsaddin2sureds1t1@unqork.com", entityPhone, province);

        EventQuote eventQuote = new EventQuote(page);
        eventQuote.isEventQuotePageLoaded();
        eventQuote.enterQuoteDetails(alcoholServed);

        EventAddedInsurance addedInsurance = new EventAddedInsurance(page);
        EventAdditionalInsureds addInsureds = new EventAdditionalInsureds(page);


        addedInsurance.isEventAddedInsurancePageLoaded();
        addedInsurance.enterAddedInsuranceDetails(addPolicy).isEventAdditionalInsuredsPageLoaded();


        addInsureds.enterAdditionalInsuredsDetails(addInsuredsName, addInsuredsEmail);

        addedInsurance.enterAddedInsuranceDetails();


        EventReviewAddedInsurance reviewIns = new EventReviewAddedInsurance(page);
        reviewIns.isEventReviewAddedInsurancePageLoaded();
        reviewIns.reviewAddedInsuranceDetails();

        EventPaymentDetails paymentDet = new EventPaymentDetails(page);
        paymentDet.isEventPaymentDetailsPageLoaded();
        paymentDet.enterPaymentDetails(addCard);

        EventProtected eventDash = new EventProtected(page);
        eventDash.isEventProtectedPageLoaded();
        eventDash.eventDashboard();

    }


    @Test(description = "Validate to Purchase an event with Duplicate Email Address", priority = 1, dataProvider = "eventUI_Web_TestData", dataProviderClass = DataProviderUtils.class)
    public void validate_Event_E2EScenario_SingleEvent_DuplicateEmailAddress(String eventType, String eventLocation, String eventHostingType, String coverageDays, String startDate, String selectHour, String selectMinute, String selectAmPm, String endDate, String selectEndHour, String selectEndMinute, String selectEndAmPm, String numberOfAttendees, String alcoholServed, String nameOfEvent, String eventHost, String entityName, String addPolicy, String addCard, String addInsuredsName, String addInsuredsEmail, String province, String entityEmail, String entityPhone, String addInfo){
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
        eventCov.enterCoverageDetails(eventHost, entityName, "monika.srivastava@aidenai.com", entityPhone, province);
        eventCov.isAccountAlreadyRegisteredLoaded();


    }


    @Test(description = "Validate to Purchase an event policy with Add Card Payment", priority = 1, dataProvider = "eventUI_Web_TestData", dataProviderClass = DataProviderUtils.class)
    public void validate_Event_E2EScenario_Payment_AddCard(String eventType, String eventLocation, String eventHostingType, String coverageDays, String startDate, String selectHour, String selectMinute, String selectAmPm, String endDate,  String selectEndHour, String selectEndMinute, String selectEndAmPm, String numberOfAttendees, String alcoholServed, String nameOfEvent, String eventHost, String entityName, String addPolicy,String addCard, String addInsuredsName, String addInsuredsEmail,String province, String entityEmail,  String entityPhone, String addInfo){
        System.out.println("Validate : To Purchase an event policy with Add Card Payment");

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
        eventCov.enterCoverageDetails(eventHost, entityName, "monika.srivastava-x+testaddcard@unqork.com", entityPhone, province);

        EventQuote eventQuote = new EventQuote(page);
        eventQuote.isEventQuotePageLoaded();
        eventQuote.enterQuoteDetails(alcoholServed);

        EventAddedInsurance addedInsurance = new EventAddedInsurance(page);
        addedInsurance.isEventAddedInsurancePageLoaded();
        addedInsurance.enterAddedInsuranceDetails();

        EventReviewAddedInsurance reviewIns = new EventReviewAddedInsurance(page);
        reviewIns.isEventReviewAddedInsurancePageLoaded();
        reviewIns.reviewAddedInsuranceDetails();

        EventPaymentDetails paymentDet = new EventPaymentDetails(page);
        paymentDet.isEventPaymentDetailsPageLoaded();
        paymentDet.enterPaymentDetails(addCard);

        EventProtected eventDash = new EventProtected(page);
        eventDash.isEventProtectedPageLoaded();
        eventDash.eventDashboard();

    }

    @Test(description = "Validate to Purchase multiple non-sports event policy with alcohol served", priority = 1, dataProvider = "eventUI_Web_TestData", dataProviderClass = DataProviderUtils.class)
    public void validate_Event_E2EScenario_MultipleEvents_AlcoholServed(String eventType, String eventLocation, String eventHostingType, String coverageDays, String startDate, String selectHour, String selectMinute, String selectAmPm, String endDate,  String selectEndHour, String selectEndMinute, String selectEndAmPm, String numberOfAttendees, String alcoholServed, String nameOfEvent, String eventHost, String entityName, String addPolicy,String addCard,String addInsuredsName, String addInsuredsEmail, String province, String entityEmail,  String entityPhone, String addInfo){
        System.out.println("Validate : To Purchase  Multiple non-sports event policy with alcohol served");

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
        eventCov.enterCoverageDetails(eventHost, entityName, "monika.srivastava-x+112alcoholserved@unqork.com", entityPhone, province);

        EventQuote eventQuote = new EventQuote(page);
        eventQuote.isEventQuotePageLoaded();
        eventQuote.enterQuoteDetails(alcoholServed);

        EventAlcohol eventAlcohol = new EventAlcohol(page);
        eventAlcohol.isEventAlcoholServedPageLoaded();
        eventAlcohol.eventVenueResponsible("No");

        EventAddedInsurance addedInsurance = new EventAddedInsurance(page);
        addedInsurance.isEventAddedInsurancePageLoaded();
        addedInsurance.enterAddedInsuranceDetails();

        EventReviewAddedInsurance reviewIns = new EventReviewAddedInsurance(page);
        reviewIns.isEventReviewAddedInsurancePageLoaded();
        reviewIns.reviewAddedInsuranceDetails();

        EventPaymentDetails paymentDet = new EventPaymentDetails(page);
        paymentDet.isEventPaymentDetailsPageLoaded();
        paymentDet.enterPaymentDetails(addCard);

        EventProtected eventDash = new EventProtected(page);
        eventDash.isEventProtectedPageLoaded();
        eventDash.eventDashboard();

    }


    @Test(description = "Validate to Purchase a sports event with Alcohol Served", priority = 1, dataProvider = "eventUI_Web_TestData", dataProviderClass = DataProviderUtils.class)
    public void validate_Event_E2EScenario_SingleEvent_Sports_AlcoholServed(String eventType, String eventLocation, String eventHostingType, String coverageDays, String startDate, String selectHour, String selectMinute, String selectAmPm, String endDate, String selectEndHour, String selectEndMinute, String selectEndAmPm, String numberOfAttendees, String alcoholServed, String nameOfEvent, String eventHost, String entityName, String addPolicy, String addCard, String addInsuredsName, String addInsuredsEmail, String province, String entityEmail, String entityPhone, String addInfo){
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
        eventDet.isCoverageUnavailableLoaded();



    }


}
