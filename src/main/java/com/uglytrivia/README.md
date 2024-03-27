BugZero Kata using UglyTrivia
==

The Kata will follow the rules and instructions on the
corresponding [Kata-log page](https://kata-log.rocks/bugs-zero-kata).
The code snippets were take from the [linked repository](https://github.com/caradojo/trivia/tree/master/java).

## Additional (own) requirements:

* We want to track how many cards were played and how many of which category. The amounts will be shown at the end of
  the game (after finding a winner).
* We want to extend the game duration. The amount of coins that is needed to win the game should be configurable. The
  minimum amount of coins is 3.
* We want to play with different types of players. An adult player gets 1 coins for a correct answer. A child gets 2
  coins for a correct answer.

## Future requirements

* The question deck could run out of questions. Make sure it can't happen.(Assume the random numbers follow a uniform
  distribution.)