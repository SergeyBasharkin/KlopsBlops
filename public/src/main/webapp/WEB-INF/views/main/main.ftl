<#include "../template/mainTemplate.ftl">
<@mainTemplate title="Главная" styles=["css/foundation.css","css/test.css","css/cart.css","/css/reset.css","/css/style.css"] scripts=["js/catalog/catalog.js"] />
<#macro m_body>

<div class="row">
    <div class="large-12 columns">

        <!-- End Desktop Slider -->


        <!-- Mobile Header -->


        <div class="row">
            <div class="small-12 show-for-small"><br>
                <img src="http://placehold.it/1000x600&text=For Small Screens" />
            </div>
        </div>


        <!-- End Mobile Header -->

    </div>
</div><br>

<div class="row">
    <div class="large-12 columns">
        <div class="row">

            <!-- Thumbnails -->

            <div class="large-3 small-6 columns">
                <a href="/catalog/3"><img src="../../../resources/img/SUOB121_sa000_sr8.jpg" />
                <h6 class="panel">Cool</h6></a>
            </div>

            <div class="large-3 small-6 columns">
                <a href="/catalog/6"> <img src="../../../resources/img/SUOB130_sa000_sr8.jpg" />
                <h6 class="panel">Animal</h6></a>
            </div>

            <div class="large-3 small-6 columns">
                <a href="/catalog/7"><img src="../../../resources/img/SUOB704_sa000_sr8.jpg" />
                <h6 class="panel">Lucky</h6></a>
            </div>

            <div class="large-3 small-6 columns">
                <a href="/catalog/4"> <img src="../../../resources/img/SUOB709_sa000_sr8.jpg" />
                <h6 class="panel">Originals</h6></a>
            </div>

            <!-- End Thumbnails -->

        </div>
    </div>
</div>



<div class="row">
    <div class="large-12 columns">
        <div class="row">

            <!-- Content -->

            <div class="large-8 columns">
                <div class="panel radius">

                    <div class="row">
                        <div class="large-6 small-6 columns">

                            <h4>Header</h4><hr/>
                            <h5 class="subheader">Risus ligula, aliquam nec fermentum vitae, sollicitudin eget urna. Donec dignissim nibh fermentum odio ornare sagittis.
                            </h5>

                            <div class="show-for-small" align="center">
                                <a href="#" class="small radius button">Call To Action!</a><br>

                                <a href="#" class="small radius button">Call To Action!</a>
                            </div>

                        </div>
                        <div class="large-6 small-6 columns">

                            <p>Suspendisse ultrices ornare tempor. Aenean eget ultricies libero. Phasellus non ipsum eros. Vivamus at dignissim massa. Aenean dolor libero, blandit quis interdum et, malesuada nec ligula. Nullam erat erat, eleifend sed pulvinar ac. Suspendisse ultrices ornare tempor. Aenean eget ultricies libero.
                            </p>
                        </div>

                    </div>
                </div>
            </div>

            <div class="large-4 columns hide-for-small">

                <h4>Get In Touch!</h4><hr/>

                <a class="large button expand" href="#">
                    Call To Action!
                </a>

                <a class="large button expand" href="#">
                    Call To Action!
                </a>


            </div>

            <!-- End Content -->

        </div>
    </div>
</div>

</#macro>