<%@include file="header.jsp" %><div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
      
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">

        <img src="images/a.jpg" alt="Watch1" width="460" height="345">
      </div>

      <div class="item">
        <img src="images/x.jpg" alt="Watch2" width="460" height="345">
      </div>
    
      <div class="item">
        <img src="images/y.jpg" alt="Watch3" width="460" height="345">
      </div>

      <div class="item">
        <img src="images/z.jpg" alt="Watch5" width="460" height="345">

        <img src="images/11.jpg" alt="Watch1" width="460" height="345">
      </div>

      <div class="item">
        <img src="images/7.jpg" alt="Watch2" width="460" height="345">
      </div>
    
      <div class="item">
        <img src="images/2.jpg" alt="Watch3" width="460" height="345">
      </div>

      <div class="item">
        <img src="images/5.jpg" alt="Watch5" width="460" height="345">

       

      </div>

    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>


<%@include file="footer.jsp"%>