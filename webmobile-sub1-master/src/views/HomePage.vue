<template>
  <div>
    <go-top></go-top>
    <Header/>
    <ImgBanner  imgSrc="https://source.unsplash.com/random/1600x900">
      <div style="line-height:1.2em;" slot="text">We will find a way.<br> We always have.</div>
    </ImgBanner>
    <v-container>
      <!-- About Me -->
      <v-layout my-5 style="text-align:center;">
        <v-flex sm6 class="text-sm-left">
          <h2 class="headline mb-3">About Me</h2>
          <p class="mr-6" v-resize-text="{ratio:0.8, minFontSize:'10px', maxFontSize:'20px',delay:200}">안녕하세요, SSAFY 참가자 여러분!<br/>함께 프로젝트를 진행하게 되어서 기쁩니다. Vue는 어렵지 않습니다. 차근차근 하나씩 따라하다보면 어느새 멋진 블로그가
            만들어져 있을겁니다! 모두 화이팅 하시고, 꼭 완성해서 좋은 평가 있길 바라겠습니다.</p>
        </v-flex>
        <v-flex sm6>
          <v-img :src="getImgUrl('profile.png')" aspect-ratio="1.5"/>
        </v-flex>
      </v-layout>

      <!-- Portfolio -->
      <v-layout my-5>
        <v-flex xs12>
          <h2 class="headline my-5 text-xs-center">Portfolio</h2>
          <PortfolioList>
            
          </PortfolioList>
        </v-flex>
      </v-layout>

      <!-- Post -->
      <v-layout my-5>
        <v-flex xs12>
          <h2 class="headline my-5 text-xs-center">Post</h2>
          <PostList :column="2"></PostList>
        </v-flex>
      </v-layout>


      <!-- Github -->
      <v-layout my-5>
        <v-flex xs12>
          <h2 class="headline my-5 text-xs-center">Project</h2>
          <RepositoryList></RepositoryList>
        </v-flex>
      </v-layout>
    </v-container>
    <Footer/>
    
  </div>
  
</template>

<script>
import ImgBanner from '../components/ImgBanner'
import PortfolioList from '../components/PortfolioList'
import PostList from '../components/PostList'
import RepositoryList from '../components/RepositoryList'
import Header from '../components/Header'
import Footer from '../components/Footer'
import Alert from '../components/Alert'
import GoTop from '@inotom/vue-go-top'

export default {
	name: 'HomePage',
	components: {
    Header,
		ImgBanner,
		PortfolioList,
		PostList,
		RepositoryList,
    Footer,
    Alert,
    GoTop
	},
	methods: {
		getImgUrl(img) {
			return require('../assets/' + img)
		}
  },
}
</script>

