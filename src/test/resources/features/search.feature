Feature: Search on Booking.com

  Scenario: Search by city criteria
    Given User is looking for "Minsk" city
    When User does search
    Then Hotel 'DoubleTree by Hilton Минск' should be on the first page
    And Rating of the 'DoubleTree by Hilton Минск' is '9,2'

  Scenario: Search by city criteria
    Given User is looking for "Brest" city
    When User does search
    Then Hotel 'Hampton by Hilton Brest' should be on the first page
    And Rating of the 'Hampton by Hilton Brest' is '9,3'