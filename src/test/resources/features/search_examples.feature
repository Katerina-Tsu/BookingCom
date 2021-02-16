Feature: Search on Booking.com

  Scenario Outline: Search by city criteria
    Given User is looking for '<City>' city
    When User does search
    Then Hotel '<Hotel>' should be on the first page

    Examples:
      | City  | Hotel                |
      | Minsk | DoubleTree by Hilton |
      | Brest | Hampton by Hilton   |