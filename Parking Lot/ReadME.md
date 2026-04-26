Parking Lot :

Approach :
1. Vehicle enters through a entry gate.
2. Ticket is issued.
3. Vehicle is parked.
4. Vehicle is picked-up.
5. At the exit gate it will pay the bill.
6. Vehicle exits.

Requirements :
1. Multiple floors can be available.
2. Vehicle can be of multiple types.
3. Parking Spot can be multiple types.
4. Payment strategy can be of multiple types.
5. Many floors can be available.
6. Many entry gates, exit gates are available.

Objects :
1. Vehicle -> its enum and sub-classes.
2. Ticket
3. Parking Lot -> its a whole object.
4. Parking Spot -> its enum and inherited classes
5. Entry Gate -> its service with multiple entry gates.
6. Exit Gate -> its service with multiple exit gates.
7. Parking Strategy -> its inherited strategies.
8. Payment Type -> its inherited strategies.
9. Floor -> we can directly use map.

Functions :
1. Searching parking space among all floors.
2. Allotting spot.
3. Release vehicle.
4. Issuing ticket
5. Payment.

Services : 
EntryGateService, ExitGateService, TicketService

Strategies : 
PaymentStrategy, PricingStrategy, SpotAllocationStrategy.

Record : 
Bill

Abstract Classes :
ParkingSpot, Vehicle 

Enums : 
ParkingSpotType, VehicleType

Classes :
ParkingLot, Ticket, Floor, EntityGate, ExitGate


Final entity diagram will look like this
<img width="1708" height="1218" alt="image" src="https://github.com/user-attachments/assets/5bf58328-5e86-49de-a989-566260b0df16" />




Final takeaways :
1. ParkingLot creates ticket, but doesn't need to handle ticketService.
2. EntryGate has to handle ticket saving.
3. ExitGate has to handle ticket removing and billing.
4. ParkingLot is the center of the functionality, but it only contains SpotAllocationStrategy and floors.
5. SpotAllocationStrategy should depend on VehicleType not Vehicle (atleast for simple architecture).
6. EntryGateService and ExitGateService are added as an extension to the problem of single entry and exit, and we have solved it efficiently by mapping only entry and exit gates into it, and bypassing the functionality to their respecitve gates.
7. Ticket doesn't need to store vehicle or vehicleType, it is ok to store parkingSpotType, and we can use that for price calculation.
8. Price shouldn't present in the ParkingSpot, it is final calculatable based on hours spent for the vehicle, and pricingStrategy.
9. PaymentService don't generate bill, it processes the bill.
10. Bill is created intentionally as a record, as it won't change later.
11. Payment, Pricing, Spot Allocation all are strategies, but ticket, entry gate and exit gate are services, because the main theme of them is not strategy, it is functionality, and there is no need of strategy for them.
