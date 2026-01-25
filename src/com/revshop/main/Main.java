package com.revshop.main;

import java.util.Scanner;

import com.revshop.model.Payment;
import com.revshop.model.Review;
import com.revshop.service.IPaymentService;
import com.revshop.service.IReviewService;
import com.revshop.service.PaymentServiceImpl;
import com.revshop.service.ReviewServiceImpl;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Service implementations
        IPaymentService paymentService = new PaymentServiceImpl();
        IReviewService reviewService = new ReviewServiceImpl();

        while (true) {
            System.out.println("\n=== RevShop Menu ===");
            System.out.println("1. Add Payment");
            System.out.println("2. Add Review");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    Payment payment = new Payment();




                    System.out.print("Enter Order Id: ");
                    payment.setOrderId(sc.nextInt());

                    System.out.print("Enter Amount: ");
                    payment.setAmount(sc.nextDouble());
                    sc.nextLine(); // consume newline

                    System.out.print("Enter Payment Method: ");
                    payment.setPaymentMethod(sc.nextLine());

                    System.out.print("Enter Payment Status: ");
                    payment.setPaymentStatus(sc.nextLine());

                    // ✅ Call service method to insert payment
                    paymentService.processPayment(payment);

                    System.out.println("Payment added successfully.");
                    break;

                case 2:
                    Review review = new Review();

                    System.out.print("Enter Review Id: ");
                    review.setReviewId(sc.nextInt());

                    System.out.print("Enter Product Id: ");
                    review.setProductId(sc.nextInt());

                    System.out.print("Enter User Id: ");
                    review.setUserId(sc.nextInt());

                    System.out.print("Enter Rating (1-5): ");
                    review.setRating(sc.nextInt());
                    sc.nextLine(); // consume newline

                    System.out.print("Enter Review Comment: ");
                    review.setReviewComment(sc.nextLine());

                    // ✅ Call service method to insert review
                    reviewService.addReview(review);

                    System.out.println("Review added successfully.");
                    break;

                case 3:
                    System.out.println("Exiting RevShop.");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}