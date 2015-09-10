# Text-Based-Adventure-Game

Design a text adventure game which reads its scenarios, layout, activities, etc. from a text file.

# Anlysis

## What are the minimum required aspects for an adventure?

* Locations
* Links between locations
* Descriptions for locations
* Objects which can be location-specific
* Actions which can be performed which result in movement between locations
* Actions which interact with objects
* A personal inventory where objects can be stored and carried

## What enhancements can be made?

* NPCs which can stay in a fixed location or move around independently
* Interactions between the player and NPCs
* Interactions between NPCs

# Implementation

## How will the game information be stored in the configuration file?

Proposal: Use @ prefix to define new nodes and as the program parses these in, they will be stored in the correct place according to context.

Within the node configurations, there should be the ability to insert placeholders for game variables present in the current context.

e.g. $n for the noun being referred to, $v for the verb, etc.

## Node types:

### Comments

@comment - Read in but not stored ===

Blank lines are ignored

### Context identifiers

There will be four main contexts:

@action_id - Actions that you can perform in the game.

@direction_id - Directions in which you can travel. Location-specific ones can be created.

@item_id - Items in the game. Once defined, they can be placed in locations (or later, with actors)

@location_id - Locations in the game. Their definitions will link to their neighbouring locations on the map.

### Context initialisers


@description - A description for this location, action, item or direction

@verb - A word that the player can use to trigger an action which implements this verb

@action - A specific action available at this location

@action_description - A description to be shown when doing performing the action

@action_on_description - A description to be show when performing the action on something

@action_with_description - A description to be show when performing the action with something

@needs_noun - If used, an error message to be shown when the verb is used without a noun

@local - Makes an action available only if specifically set for a location (see @action)

@noun - A word that the player can use to identify the object (or direction, if using a GO verb)

@item - Make an item available at a location

@direction - A direction available at a location
               
| Initialiaser             | Action | Direction | Item | Location | 
| ------------------------ | ------ | --------- | -----| -------- |
| @description             |    X   |     X     |   X  |     X    |
| @verb                    |    X   |     X     |      |     X    |
| @action                  |        |           |      |          |
| @action_description      |        |           |      |          |
| @action_on_description   |        |           |      |          |
| @needs_noun              |        |           |      |          |
| @local                   |        |           |      |          |
| @noun                    |        |           |      |          |
| @item                    |        |           |      |          |
| @direction               |        |           |      |          |

### Node hierarchy

#### @action_id

    @verb - The verb for the player to use to perform this action, i.e. “GO”, “LOOK”

    @action_description - A descriptive term for this action, e.g. “you examine the $n”

    @action_on_description - Description when doing this action on something

    @needs_noun - If used, an error message for when verb is used with no noun

#### @direction_id

    @description - Description for this direction

    @noun - Nouns to be used by player for this direction, e.g. “E, EAST”

#### @location_id

	@description - The description for this location

	@action - Actions available at this location

	@item - Items initially at this location

	@direction - A direction out of this location

#### @item_id

    @name - Identifier for player to use for this item, e.g. “box”, “large box”. Multiple names can be defined, with the program matching the most general one unless more than one is in the current location or inventory.

	@description - Description of this object

    @actions_on - Actions which can be performed on this item

    @actions_with - Actions which can be performed with this item

