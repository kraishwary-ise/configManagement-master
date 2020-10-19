import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NameEmail } from '../models/triggerDrag';
import { Trigger } from '../models/trigger';
import { TriggerService } from '../service/trigger.service';

declare var $:any;



@Component({
  selector: 'app-trigger',
  templateUrl: './trigger.component.html',
  styleUrls: ['./trigger.component.css']
})
export class TriggerComponent implements OnInit {


  triggerDrag=[];

  trigger = [];

  triggerSelected=[];
  id;
  email;
  msg;
  msgExist=false;

  triggerForm=new Trigger();

  constructor(private router:Router,private triggerService:TriggerService,private route:ActivatedRoute) { 

    this.triggerService.getTrigger().subscribe(response=> {

      this.trigger=response;

      console.log(this.trigger);

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


    if(this.triggerSelected.length==0) {
      this.msg="please select at least one trigger library";
      this.msgExist=true;
      $('.alert').show();

    }

    else {

    this.triggerDrag=[];
    for(let i=0;i<this.triggerSelected.length;i++) {



      this.triggerDrag.push(new NameEmail(this.id,this.triggerSelected[i].name));


  }
  this.triggerService.saveTrigger(this.triggerDrag).subscribe(response=> {

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


  openOffers() {

    this.router.navigate(['/offers',this.id]);

  }


  closeAlert() {

    $('.alert').hide()
  
  
  }
  
}
