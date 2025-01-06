package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
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

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository = outsourcedPartRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        int numParts = (int) partRepository.count();
        int numProducts = (int) productRepository.count();

            Set<Product> products = new HashSet<Product>();
            Set<Part> parts = new HashSet<Part>();

            Product firstProduct = new Product(1,"Bolt-Action Rifle", 900.00, 12);
            Product secondProduct = new Product(2,"Semi-Automatic Rifle", 1500.00, 22);
            Product thirdProduct = new Product(3,"Long-Range Rifle", 519.00, 7);
            Product fourthProduct = new Product(4,"Youth Rifle", 200.00, 35);
            Product fifthProduct = new Product(5,"Pump-Action Rifle", 599.00, 19);


            products.add(firstProduct);
            products.add(secondProduct);
            products.add(thirdProduct);
            products.add(fourthProduct);
            products.add(fifthProduct);



            InhousePart firstInhousePart = new InhousePart();
            firstInhousePart.setId(100);
            firstInhousePart.setName("Trigger Assembly");
            firstInhousePart.setPrice(250.00);
            firstInhousePart.setInv(40);

            InhousePart secondInhousePart = new InhousePart();
            secondInhousePart.setId(202);
            secondInhousePart.setName("Foregrip");
            secondInhousePart.setPrice(150.00);
            secondInhousePart.setInv(34);

            InhousePart thirdInhousePart = new InhousePart();
            thirdInhousePart.setId(252);
            thirdInhousePart.setName("Stock");
            thirdInhousePart.setPrice(350.00);
            thirdInhousePart.setInv(45);

            OutsourcedPart firstOutsourcedPart = new OutsourcedPart();
            firstOutsourcedPart.setCompanyName("Bell-Toll");
            firstOutsourcedPart.setId(900);
            firstOutsourcedPart.setName("Optics");
            firstOutsourcedPart.setPrice(700.00);
            firstOutsourcedPart.setInv(250);

            OutsourcedPart secondOutsourcedPart = new OutsourcedPart();
            secondOutsourcedPart.setCompanyName("Black Anchor");
            secondOutsourcedPart.setId(950);
            secondOutsourcedPart.setName("Barrel");
            secondOutsourcedPart.setPrice(500.00);
            secondOutsourcedPart.setInv(145);

            parts.add(firstInhousePart);
            parts.add(secondInhousePart);
            parts.add(thirdInhousePart);
            parts.add(firstOutsourcedPart);
            parts.add(secondOutsourcedPart);

            if (numProducts == 0) {
                for (Product product : products) {
                    productRepository.save(product);
                }
            }

        if (numParts == 0) {

            for (Part part: parts) {
                partRepository.save(part);
            }
        }


       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
