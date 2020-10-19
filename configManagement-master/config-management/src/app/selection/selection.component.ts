import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Selection } from '../models/selection';

import { selectionDrop } from '../models/selectionDrag';
import { SelectionService } from '../service/selection.service';

declare var $:any;

@Component({
  selector: 'app-selection',
  templateUrl: './selection.component.html',
  styleUrls: ['./selection.component.css']
})
export class SelectionComponent implements OnInit {

  selectionDrag=[];

  selection = [];

  selectionSelected=[];
  id;
  email;
  msg;
  msgExist=false;

  triggerForm=new Selection();

  constructor(private router:Router,private selectionService:SelectionService,private route:ActivatedRoute) { 

    this.selectionService.getSelection().subscribe(response=> {

      this.selection=response;

      console.log(this.selection);

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


    if(this.selectionSelected.length==0) {
      this.msg="please select at least one Selection ";
      this.msgExist=true;
      $('.alert').show();

    }

    else {

    this.selectionDrag=[];
    for(let i=0;i<this.selectionSelected.length;i++) {



      this.selectionDrag.push(new selectionDrop(this.id,this.selectionSelected[i].name));

    


  }

  console.log(this.selectionDrag);
  this.selectionService.saveSelection(this.selectionDrag).subscribe(response=> {

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
