/**
 * TicketMachine models a naive ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * It is a naive machine in the sense that it trusts its users
 * to insert enough money before trying to print a ticket.
 * It also assumes that users enter sensible amounts.
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private Integer price;
    // The amount of money entered by a customer so far.
    private Integer balance;
    // The total amount of money collected by this machine.
    private Integer total;
    // The number of tickets printed.
    private Integer ticketNumber;
    
    private int status;
    

    /**
     * Create a machine that issues tickets of the given price.
     * Note that the price must be greater than zero, and there
     * are no checks to ensure this.
     */
    public TicketMachine(Integer ticketCost)
    {
       price = ticketCost;
        balance = 0;
        total = 0;
        ticketNumber = 0;
    }
    
   
   /**
    * Constructor with fixed ticketCost
    */
    public TicketMachine()
    {
       price = 1000;
        balance = 0;
        total = 0;
        ticketNumber = 0;
    }
    /**
     * Return the price of a ticket.
     */
    public Integer getPrice()
    {
        return price;
    }
    
    /* set the price
     * */
     
    public void setPrice(int ticketCost)
    {
        price=ticketCost;
    }
    
    /**
     * Return the total of a ticket.
     */
    public Integer getTotal()
    {
        return total;
    }
    
    /**
     * Return ticketNumber.
     * (Increments on each print.)
     */
    public Integer getTicketNumber()
    {
        return ticketNumber;
    }

    /**
     * Return the amount of money already inserted for the
     * next ticket.
     */
    public Integer getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money in cents from a customer.
     */
    /*public Integer insertMoney(Integer amount)
    {
        balance = balance + amount;
        return balance;
    }
    */
    /**
     * Receive an amount of money in cents from a customer with conditional statement
     */
    public void insertMoney(Integer amount)
    {
        if(amount>0)
        {
        balance = balance + amount;
        //return balance;
        }
        else
        System.out.println("Use a valid amount: " +amount);
                         
    }
    
    public Integer calculateTotal(){
        total = balance + total;
        return total;
    }
    
    public Integer incrementTicketNumber(){
        ticketNumber++;
        return ticketNumber;
    }
    

    /**
     * Print a ticket.
     * Update the total collected and
     * reduce the balance to zero.
     */
    public String printTicket()
    {
        if(price<=balance)
        {
        //Increment the number of tickets printed
        incrementTicketNumber();
        // Update the total collected with the balance.
        total = total + balance;
        // Clear the balance.
        balance = 0;
        
        return "Ticket price: " + price + " cents. " + "Your total is " + total + ".";
        }
        else
        {
            int remBal=price-balance;
        return "You must insert at least: "+remBal + " more cents.";
    
        }
    }
     /**
   * Reduce price by the given amount.
   */
  public void discount(int amount)
  {
      price=price-amount;
  }
   /**
   * Alert to insert correct amount of money
   */
  public void prompt()
  {
      System.out.println("Please insert the correct amount of money.");
  }
  /**
   * Show price of the ticket
   */
  public void showPrice()
  {
      System.out.println("The price of a ticket is "+price+" cents.");
      //System.out.println("The price of a ticket is #price cents.");
  }
  /*
   * Remove funds from total
   */
  public int empty()
  {
      total=0;
      return total;
  }
  /*
  * Refund balance
  */   
  public int refundBalance()
  {
                 //int amountToRefund;
                 //amountToRefund = balance;
                 //balance = 0;
                 //return amountToRefund;
      balance = 0;
      return balance;
  }

}
