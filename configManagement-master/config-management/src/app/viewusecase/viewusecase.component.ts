import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ViewUseCaseService } from '../service/view-use-case.service';

import {NgbModal, ModalDismissReasons}  
      from '@ng-bootstrap/ng-bootstrap'; 
import { ExportImportService } from '../service/export-import.service';
import { UsecaseService } from '../service/usecase.service';

declare var $: any;

@Component({
  selector: 'app-viewusecase',
  templateUrl: './viewusecase.component.html',
  styleUrls: ['./viewusecase.component.css']
})
export class ViewusecaseComponent implements OnInit {

  hiddenelement=true;

  listUseCase=[];

  email;

  msg;

  msgExist=false;

  closeResult = ''; 

  userFile:any=File;

  pageNumber:number=1;

  constructor(private exportImport:ExportImportService,private useCaseService: UsecaseService,private modalService: NgbModal,private viewUseCase:ViewUseCaseService,private router:Router) {



    this.viewUseCase.getListUseCase().subscribe(response=> {

      this.listUseCase=response;

      console.log(response)

    },error=> {

      console.log(error);

      

    }) 

    
    
  }

  ngOnInit() {
  }
  
  listOrAddUseCase() {

    this.router.navigate(['/addUseCase'])
    


  }

 

  open(content) { 
    this.modalService.open(content, 
   {ariaLabelledBy: 'modal-basic-title'}).result.then((result)   => { 
      this.closeResult = `Closed with: ${result}`; 
    }, (reason) => { 
      this.closeResult =  
         `Dismissed ${this.getDismissReason(reason)}`; 
    }); 
  } 
  
  private getDismissReason(reason: any): string { 
    if (reason === ModalDismissReasons.ESC) { 
      return 'by pressing ESC'; 
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) { 
      return 'by clicking on a backdrop'; 
    } else { 
      return `with: ${reason}`; 
    } 
  } 

  selectFile(event:any) {

    this.userFile = event.target.files;  
   

  }


  



  importUseCase() {


    const formData  = new FormData();

    for(var i=0;i<this.userFile.length;i++) {
    formData.append("file",this.userFile[i]);

    }
    console.log(this.userFile);
    console.log(formData)
    this.viewUseCase.importUseCase(formData).subscribe(response=> {

      this.msg="UseCases Imported Sucessfully. please reload the page to see all imported UseCases";
      console.log(this.msg);
      this.msgExist=true;
      $('.alert').show()

    }, error=> {
      this.msg="Some Errror Occured"
      this.msgExist=true;
      $('.alert').show()
    })

    


  }

  


eachUseCase(event:any,res:any) {


  console.log(res);

  this.exportImport.eachUseCase(res.id).subscribe(response=> {
    this.msg="UseCase " + res.name +   " has been Exported Successfully"
    this.msgExist=true;
    $('.alert').show()

    
  },error=> {
    this.msg="Some error has occured while Exporting " + res.name;
    this.msgExist=true;
  })

}

deleteUseCase(event:any,res:any) {

  this.useCaseService.deleteUseCase(res.id).subscribe(response=> {
    this.msg="Use Case " + res.name + " has deleted Sucessfully"
    this.msgExist=true;
    $('.alert').show()


  },error=> {
    this.msg="Some error has occured while deleting the UseCase " + res.name;
    this.msgExist=true;
  })
 

}

openTrigger(event:any,res:any) {

  this.router.navigate(['/trigger',res.id]);
  
}

  closeAlert() {

    $('.alert').hide()
  
  
  }
  

}



