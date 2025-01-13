package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;
    private final OutsourcedPartRepository outsourcedPartRepository;
    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository = outsourcedPartRepository;
        this.inhousePartRepository = inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<InhousePart> inhouseParts = (List<InhousePart>) inhousePartRepository.findAll();
        long numProducts = productRepository.count();
        long numParts = partRepository.count();

        Set<Product> products = new HashSet<>();
        Set<Part> parts = new HashSet<>();

        Product firstProduct = new Product(1, "Rifle", 900.00, 12);
        Product secondProduct = new Product(2, "Pistol", 1500.00, 22);
        Product thirdProduct = new Product(3, "Maintenance Kit", 519.00, 7);
        Product fourthProduct = new Product(4, "Medical Kit", 200.00, 35);
        Product fifthProduct = new Product(5, "Targets Kit", 599.00, 19);

        products.add(firstProduct);
        products.add(secondProduct);
        products.add(thirdProduct);
        products.add(fourthProduct);
        products.add(fifthProduct);

        InhousePart firstInhousePart = new InhousePart();
        firstInhousePart.setName("Trigger Assembly");
        firstInhousePart.setId(99);
        firstInhousePart.setPrice(250.00);
        firstInhousePart.setInv(40);
        firstInhousePart.setMinInv(0);
        firstInhousePart.setMaxInv(75);

        InhousePart secondInhousePart = new InhousePart();
        secondInhousePart.setName("Foregrip");
        secondInhousePart.setId(90);
        secondInhousePart.setPrice(150.00);
        secondInhousePart.setInv(34);
        secondInhousePart.setMinInv(0);
        secondInhousePart.setMaxInv(100);

        InhousePart thirdInhousePart = new InhousePart();
        thirdInhousePart.setName("Stock");
        thirdInhousePart.setId(100);
        thirdInhousePart.setPrice(350.00);
        thirdInhousePart.setInv(45);
        thirdInhousePart.setMinInv(0);
        thirdInhousePart.setMaxInv(95);

        InhousePart fourthInhousePart = new InhousePart();
        fourthInhousePart.setName("Gun Oil");
        fourthInhousePart.setId(122);
        fourthInhousePart.setPrice(20.00);
        fourthInhousePart.setInv(42);
        fourthInhousePart.setMinInv(0);
        fourthInhousePart.setMaxInv(75);

        InhousePart fifthInhousePart = new InhousePart();
        fifthInhousePart.setName("Q-Tips");
        fifthInhousePart.setId(899);
        fifthInhousePart.setPrice(2.00);
        fifthInhousePart.setInv(42);
        fifthInhousePart.setMinInv(0);
        fifthInhousePart.setMaxInv(75);

        OutsourcedPart firstOutsourcedPart = new OutsourcedPart();
        firstOutsourcedPart.setCompanyName("Bell-Toll");
        firstOutsourcedPart.setId(101);
        firstOutsourcedPart.setName("Optic");
        firstOutsourcedPart.setPrice(700.00);
        firstOutsourcedPart.setInv(250);
        firstOutsourcedPart.setMinInv(0);
        firstOutsourcedPart.setMaxInv(275);

        OutsourcedPart secondOutsourcedPart = new OutsourcedPart();
        secondOutsourcedPart.setCompanyName("Black Anchor");
        secondOutsourcedPart.setName("Barrel");
        secondOutsourcedPart.setId(50);
        secondOutsourcedPart.setPrice(500.00);
        secondOutsourcedPart.setInv(145);
        secondOutsourcedPart.setMinInv(0);
        secondOutsourcedPart.setMaxInv(200);

        OutsourcedPart thirdOutsourcedPart = new OutsourcedPart();
        thirdOutsourcedPart.setCompanyName("Kimbo Medical");
        thirdOutsourcedPart.setName("Pressure Dressing");
        thirdOutsourcedPart.setId(22);
        thirdOutsourcedPart.setPrice(3.75);
        thirdOutsourcedPart.setInv(150);
        thirdOutsourcedPart.setMinInv(0);
        thirdOutsourcedPart.setMaxInv(200);

        OutsourcedPart fourthOutsourcedPart = new OutsourcedPart();
        fourthOutsourcedPart.setCompanyName("Kimbo Medical");
        fourthOutsourcedPart.setName("Gauze");
        fourthOutsourcedPart.setId(1);
        fourthOutsourcedPart.setPrice(1.00);
        fourthOutsourcedPart.setInv(150);
        fourthOutsourcedPart.setMinInv(0);
        fourthOutsourcedPart.setMaxInv(200);

        OutsourcedPart fifthOutsourcedPart = new OutsourcedPart();
        fifthOutsourcedPart.setCompanyName("USA Supplies");
        fifthOutsourcedPart.setName("Staple Pack");
        fifthOutsourcedPart.setId(3);
        fifthOutsourcedPart.setPrice(3.00);
        fifthOutsourcedPart.setInv(290);
        fifthOutsourcedPart.setMinInv(0);
        fifthOutsourcedPart.setMaxInv(300);

        OutsourcedPart sixthOutsourcedPart = new OutsourcedPart();
        sixthOutsourcedPart.setCompanyName("USA Supplies");
        sixthOutsourcedPart.setName("Bullseye Targets");
        sixthOutsourcedPart.setId(230);
        sixthOutsourcedPart.setPrice(25.00);
        sixthOutsourcedPart.setInv(300);
        sixthOutsourcedPart.setMinInv(0);
        sixthOutsourcedPart.setMaxInv(300);

        parts.add(firstInhousePart);
        parts.add(secondInhousePart);
        parts.add(thirdInhousePart);
        parts.add(fourthInhousePart);
        parts.add(fifthInhousePart);
        parts.add(firstOutsourcedPart);
        parts.add(secondOutsourcedPart);
        parts.add(thirdOutsourcedPart);
        parts.add(fourthOutsourcedPart);
        parts.add(fifthOutsourcedPart);
        parts.add(sixthOutsourcedPart);

        if (numProducts == 0 && numParts == 0) {
            for (Product product : products) {
                productRepository.save(product);
            }
            for (Part part : parts) {
                partRepository.save(part);
            }
        }
        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products: " + productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts" + partRepository.count());
        System.out.println(partRepository.findAll());
    }
}

