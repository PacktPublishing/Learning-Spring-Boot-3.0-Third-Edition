# Learning Spring Boot 3.0

<a href="https://www.packtpub.com/product/learning-spring-boot-30-third-edition/9781803233307?utm_source=github&utm_medium=repository&utm_campaign=9781803233307"><img src="https://static.packt-cdn.com/products/9781803233307/cover/smaller" alt="" height="256px" align="right"></a>

This is the code repository for [Learning Spring Boot 3.0](https://www.packtpub.com/product/learning-spring-boot-30-third-edition/9781803233307?utm_source=github&utm_medium=repository&utm_campaign=9781803233307), published by Packt.

**Simplify the development of production-grade applications using Java and Spring**

## What is this book about?
Spring Boot 3 brings more than just the powerful ability to build secure web apps on top of a rock-solid database. It delivers new options for testing, deployment, Docker support, and native images for GraalVM, along with ways to squeeze out more efficient usage of existing resources.

This book covers the following exciting features:
* Create powerful, production-grade web applications with minimal fuss
* Support multiple environments with one artifact, and add production-grade support with features
* Find out how to tweak your Java apps through different properties
* Enhance the security model of your apps
* Make use of enhancing features such as native deployment and reactive programming in Spring Boot
* Build anything from lightweight unit tests to fully running embedded web container integration tests
* Get a glimpse of reactive programming and decide if it's the right approach for you

If you feel this book is for you, get your [copy](https://www.amazon.com/dp/1803233303) today!

<a href="https://www.packtpub.com/?utm_source=github&utm_medium=banner&utm_campaign=GitHubBanner"><img src="https://raw.githubusercontent.com/PacktPublishing/GitHub/master/GitHub.png" 
alt="https://www.packtpub.com/" border="5" /></a>

## Instructions and Navigations
All of the code is organized into folders. For example, Ch2.

The code will look like the following:
```
@Controller
public class HomeController {
  private final VideoService videoService;
  public HomeController(VideoService videoService) {
    this.videoService = videoService;
  }

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("videos", videoService.getVideos());
    return "index";
  }
}
```

**Following is what you need for this book:**
This book is for both novices and experienced Spring developers looking to learn how to build applications without wasting time on infrastructure and other tedious details. Working knowledge of the Java programming language is assumed.

With the following software and hardware list you can run all code files present in the book (Chapter 1-10).
### Software and Hardware List
| Chapter | Software required | OS required |
| -------- | ------------------------------------ | ----------------------------------- |
| 1-10 | sdkman (for Java 17) (https://sdkman.io) | Windows, Mac OS X, and Linux (Any) |
| 1-10 | IntelliJ IDEA (https://springbootlearning.com/ | Windows, Mac OS X, and Linux (Any) |
| 1-10 | VS Code (https://springbootlearning.com/ | Windows, Mac OS X, and Linux (Any) |
| 1-10 | Spring Tool Suite (https://springbootlearning.com/sts) | Windows, Mac OS X, and Linux (Any) |

We also provide a PDF file that has color images of the screenshots/diagrams used in this book. [Click here to download it](https://packt.link/FvE6S).

### Related products
* Spring Boot and Angular [[Packt]](https://www.packtpub.com/product/spring-boot-and-angular/9781803243214?utm_source=github&utm_medium=repository&utm_campaign=9781803243214) [[Amazon]](https://www.amazon.com/dp/180324321X)

* Full Stack Development with Spring Boot and React - Third Edition [[Packt]](https://www.packtpub.com/product/full-stack-development-with-spring-boot-and-react-third-edition/9781801816786?utm_source=github&utm_medium=repository&utm_campaign=9781801816786) [[Amazon]](https://www.amazon.com/dp/1801816786)

## Errata 
* Page 65, Note box:  **!!putting the wildcard at the beginning!!** _should be_ **!!putting the wildcard at the END!!**
* Page 65, Note box:  **EndsWith puts the wildcard at the end** _should be_ **EndsWith puts the wildcard at the beginning**

## Get to Know the Author
**Greg L. Turnquist** works on the Spring team at VMware. He is the project lead for Spring Data JPA and has committed to multiple projects including Spring Boot, Spring Security, R2DBC, Spring HATEOAS, and more. He has written the Hacking with Spring Boot series as well as Packt's best-selling title, Learning Spring Boot 2.0 2nd Edition. He co-founded the Nashville Java User Group in 2010 and hasn't met a Java app (yet) that he doesn't like.

He completed his master's degree in computer engineering at Auburn University and lives in the United States with his family.

Be sure to check out his YouTube channel, Spring Boot Learning, where you learn about Spring Boot and have fun doing it at youtube.com/@springbootlearning

### Download a free PDF

 <i>If you have already purchased a print or Kindle version of this book, you can get a DRM-free PDF version at no cost.<br>Simply click on the link to claim your free PDF.</i>
<p align="center"> <a href="https://packt.link/free-ebook/9781803233307">https://packt.link/free-ebook/9781803233307 </a> </p>
