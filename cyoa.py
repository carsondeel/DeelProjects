"""Guessing Game."""

__author__ = "Carson Deel"


import random
points: int = 0
player: str = ""
crying_face: str = "\U0001F972"


def main() -> None:
    """This is the main function which calls the other functions."""
    global points
    global player
    greet()
    x: int = int(input("Enter 1 to guess the number, 2 to guess the color, and 0 to exit: "))
    if x == 1:
        game_one()
        print(f"You now have {points} points")
        loop()
    if x == 2:
        points = game_two(points)
        print(f"You now have {points} points")
        loop()
    if x == 0:
        print(f"Thank you {player} for playing Carson's Game! Goodbye {crying_face}")


def greet() -> None:
    """Greet the player, and assign the players name to the variable."""
    global player
    print("Hello player, welcome to Carson's Game!")
    player = input("What is your name? ")


def game_one() -> None:
    """The first game where the player guesses the random number."""
    global points
    y: int = int(input(f"{player}, choose a number from 1 to 3: "))
    if y == random.randint(1, 3):
        print("Correct!")
        points = points + 1
    else:
        print("Incorrect")
        points = points - 1


def game_two(a: int) -> int:
    """Second game which the player is prompted to guess one of seven colors."""
    y: str = input(f"{player}, enter any color on the rainbow, in lowercase format: ")
    x: int = random.randint(1, 7)
    z: str = ""
    if x == 1:
        z = "red"
    if x == 2:
        z = "orange"
    if x == 3:
        z = "yellow"
    if x == 4:
        z = "green"
    if x == 5:
        z = "blue"
    if x == 6:
        z = "indigo"
    if x == 7:
        z = "voilet"
    if z == y:
        a = a + 2
        print("Correct! +2 points!")
    else:
        a = a - 1
        print("Wrong, -1 point!")
    return a


def loop() -> None:
    """Similar to the main function, allows the game to be continuous for as long as the user wants to play."""
    global points
    global player
    x: int = int(input("Enter 1 to guess the number, 2 to guess the color, and 0 to exit: "))
    if x == 1:
        game_one()
        print(f"You now have {points} points")
        loop()
    if x == 2:
        points = game_two(points)
        print(f"You now have {points} points")
        loop()
    if x == 0:
        print(f"Thank you {player} for playing Carson's Game! Goodbye {crying_face}")


if __name__ == "__main__":
    main()
