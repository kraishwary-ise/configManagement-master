import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Offer } from '../models/Offer';
import { offerDrop } from '../models/offerDrag';
import { OfferService } from '../service/offer.service';

declare var $:any;

@Component({
  selector: 'app-offers',
  templateUrl: './offers.component.html',
  styleUrls: ['./offers.component.css']
})
export class OffersComponent implements OnInit {


  offerDrag=[];

  offer = [];

  offerSelected=[];
  id;
  email;
  msg;
  msgExist=false;

  triggerForm=new Offer();

  constructor(private router:Router,private offerService:OfferService,private route:ActivatedRoute) { 

    this.offerService.getOffer().subscribe(response=> {

      this.offer=response;

      console.log(this.offer);

    },error=> {
      console.log(error)
    })

 this.route.paramMap.subscribe(params=> {

     this.id=params.get('useCaseId');

      })

  }

  drop(event: CdkDragDrop<string[]>) {
    if (event.previousContainer === event.container) {
      moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
    } else {
      transferArrayItem(event.previousContainer.data,
                        event.container.data,
                        event.previousIndex,
                        event.currentIndex);
    }
  }


   ngOnInit() {


    



  }


  save() {


    if(this.offerSelected.length==0) {
      this.msg="please select at least one offer ";
      this.msgExist=true;
      $('.alert').show();

    }

    else {

    this.offerDrag=[];
    for(let i=0;i<this.offerSelected.length;i++) {



      this.offerDrag.push(new offerDrop(this.id,this.offerSelected[i].name));

    


  }

  console.log(this.offerDrag);
  this.offerService.saveOffer(this.offerDrag).subscribe(response=> {

    console.log(response)
    this.msg="save successfully";
    this.msgExist=true;
    $('.alert').show();


  },error=> {

    this.msg="some error occured";
    this.msgExist=true;
    $('.alert').show();

    
  })
  }


   }


   openSelectionMethod() {

    this.router.navigate(['/selection',this.id]);

  }


  closeAlert() {

    $('.alert').hide()
  
  
  }
  
}
