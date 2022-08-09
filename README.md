# Medavie Ceiling Fan Test
This project implements a simple ceiling fan with these characteristics:

- The unit has 2 pull cords:
  - One increases the speed each time it is pulled. There are 3 speed settings, and an “off” (speed 0) setting. If the cord is pulled on speed 3, the fan returns to the “off” setting.
  - One reverses the direction of the fan at the current speed setting. Once the direction has been reversed, it remains reversed as we cycle through the speed settings, until reversed again.

It assumes the unit is always powered (no wall switch).

Once the program is running, operate the fan with:
- 'i' or '+' to increase the speed of the fan
- 'r' to reverse the direction of the fan