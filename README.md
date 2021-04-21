# Tax

The tax program is customized with reference to taxation standards and is a procedure for calculating taxation based on the type, number, price and other factors of the goods. This experiment only tests the functions provided by the interface gettax.

1.	Input specifications

   | Inputs       | Types  |  Limits  |Description|
   | ----| -----| ---- |----|
   |  name | String  |   | product name |
   | price |  double |  | commodity price  |
   | imported | boolean |  |  |
   |quantity |  int |  |   |
   | area | String  | Only "local" or "other" |  |

2.	Output specifications

   The output parameter that can be obtained by calling the gettax function interface is taxedCost, which is of double type.
 
3.	Description of MRs

   The input of the service to be tested is divided into equivalence classes, and then the MRs is designed by analyzing the necessary attributes existing between different equivalence classes.
![](https://cdn.jsdelivr.net/gh/Evan-ZJ/MyPic/img/20210421204500.jpg)
