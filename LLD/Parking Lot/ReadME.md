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
EntryGateService, ExitGateService.

EntryGateService : 
when a user enters through a entry gate, it will let the entry gate to park the vehicle by navigating to parking lot.
It handles a list of entry gates.

<img width="965" height="325" alt="image" src="https://github.com/user-attachments/assets/a3f013d7-6023-41f5-af9e-41e2556fa585" />




